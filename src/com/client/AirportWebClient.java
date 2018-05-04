package com.client;

import com.ws.Flight;
import com.ws.AirportServiceService;
import com.ws.Reservation;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.ws.AirportService;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AirportWebClient extends JFrame {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);

    private String[] columnNames
            = {"Lot z", "Lot do", "Dzień", "Godzina"};
    
   
    
    String concertName;

    JPanel flights = new JPanel();
    JPanel reservations = new JPanel();

    JList lista;
    JList resvList1;
    JList resvList2;
    JList resvList3;
    JList resvList4;

    JButton rezerwuj = new JButton("Dodaj do rezerwacji");
    JButton potwierdz = new JButton("Potwierdź rezerwację");
    JButton anuluj = new JButton("Anuluj rezerwację");
    JButton innemiejsce = new JButton("Zmień miejsce");
    JButton potwinnemiejsce = new JButton("Potwierdź");

    JLabel resLabel = new JLabel("Dostępne miejsca");
    JLabel resLabel2 = new JLabel("Wybrane miejsca");
    JLabel resLabel3 = new JLabel("Wynik");
    JLabel resLabel4 = new JLabel("Wynik");

    JScrollPane skrolpanel;
    JScrollPane skrolpanel2;
    JScrollPane skrolpanel3;
    JScrollPane skrolpanel4;

    JTabbedPane tabs = new JTabbedPane();

    DefaultListModel model = new DefaultListModel();
    DefaultListModel modelRes = new DefaultListModel();
    DefaultListModel modelRes2 = new DefaultListModel();
    DefaultListModel modelRes3 = new DefaultListModel();
    DefaultListModel modelRes4 = new DefaultListModel();

    static AirportServiceService mss;
    static AirportService ms;

    static List<Flight> listakon;
    static List<Reservation> listares;
    static List<Reservation> listares2;
    static List<Reservation> listares3;
    static List<Reservation> listares4;
    
//       private DefaultTableModel tableModel = new DefaultTableModel(listakon, columnNames);
//    private JTable jTable = new JTable(tableModel);
//
//    private TableRowSorter<TableModel> rowSorter
//            = new TableRowSorter<>(jTable.getModel());
//
//    private JTextField jtfFilter = new JTextField();
//    private JButton jbtFilter = new JButton("Filter");

    ActionListener anulujMiejsce = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {

            resvList3.getSelectedIndex();

            ms.deleteReservation(listares3.get(resvList3.getSelectedIndex()).getIdReservation());

            listares3 = ms.getReservationList2(1);

            modelRes3 = new DefaultListModel();

            for(Reservation reserw:listares3) {

                modelRes3.addElement("Id: "+reserw.getIdReservation()+", Lot: "+reserw.getIdFlight());

            }

            resvList3.setModel(modelRes3);

            modelRes4 = new DefaultListModel();

            listares4 = new ArrayList<>();

            resvList4.setModel(modelRes4);
        }
    };

    ActionListener zmienMiejsce = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {

            resvList3.getSelectedIndex();

            listares4 = ms.getReservationList(listares3.get(resvList3.getSelectedIndex()).getIdFlight());

            modelRes4 = new DefaultListModel();

            for(Reservation reserw:listares4) {

                modelRes4.addElement("Id: "+reserw.getIdReservation()+", Lot: "+reserw.getIdFlight());

            }

            resvList4.setModel(modelRes4);
        }
    };

    ActionListener zmienMiejsce2 = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {

            listares3 = ms.getReservationList2(1);

            modelRes3 = new DefaultListModel();

            for(Reservation reserw:listares3) {

                modelRes3.addElement("Id: "+reserw.getIdReservation()+", Lot: "+reserw.getIdFlight());

            }

            resvList3.setModel(modelRes3);

            modelRes4 = new DefaultListModel();

            listares4 = new ArrayList<>();

            resvList4.setModel(modelRes4);
        }
    };

    ActionListener rezerwujList = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {

            modelRes2 = new DefaultListModel();

            Reservation reserved = listares.get(resvList1.getSelectedIndex());

            if(listares2.contains(reserved))
            {
            }
            else {
                listares2.add(reserved);
            }
            for (Reservation resv : listares2) {
                modelRes2.addElement(resv.getIdReservation() + " " + resv.getIdFlight() + " " + resv.getUser());
            }
            resvList2.setModel(modelRes2);
        }
    };


    ActionListener potwierdzenie = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {

            boolean rezerwacja;
            rezerwacja = ms.checkReservation(listares2,1);

            if(rezerwacja) {

                resLabel3.setText("Dokonano rezerwacji");
                try {
                    generatePDF(listares2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

                listares3 = ms.getReservationList2(1);

                modelRes3 = new DefaultListModel();

                for(Reservation reserw:listares3) {

                    modelRes3.addElement("Id: "+reserw.getIdReservation()+", Lot: "+reserw.getIdFlight());

                }

                resvList3.setModel(modelRes3);
            }
            else
                resLabel3.setText("Jedno lub więcej wybranych miejsc jest zajęte");

            modelRes = new DefaultListModel();
            modelRes2 = new DefaultListModel();

            listares2 = new ArrayList<>();
            listares = new ArrayList<>();

            resvList1.setModel(modelRes);
            resvList2.setModel(modelRes2);
        }
    };

    ListSelectionListener wczytajKoncert = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = lista.getSelectedIndex();


            concertName = (String) lista.getSelectedValue();

            listares = ms.getReservationList(listakon.get(index).getId());

            modelRes = new DefaultListModel();
            modelRes2 = new DefaultListModel();

            resvList2.setModel(modelRes2);
            listares2 = new ArrayList<>();

            resvList1.setModel(modelRes);
        }
    };

        public static void main (String[]args) throws IOException, DocumentException {

            mss = new AirportServiceService();
            ms = mss.getAirportServicePort();

            listakon = new ArrayList<>();
            listakon = ms.getFlightList();
            listares2 = new ArrayList<>();

            listares3 = ms.getReservationList2(1);
            listares4 = new ArrayList<>();

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new AirportWebClient();
                }
            });
        }

        public void generatePDF(List<Reservation> miejsca) throws FileNotFoundException, DocumentException {

            DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
            Date date = new Date();
            System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

            String nazwapliku = "/Users/ewa/Downloads/AirportClient/Rezerwacja"+dateFormat.format(date)+".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nazwapliku));

            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            Chunk chunk = new Chunk(concertName, catFont);

            Paragraph para = new Paragraph(concertName,catFont);

            document.add(para);

            document.add(chunk.NEWLINE);
            document.add(chunk.NEWLINE);

             for(Reservation res1:miejsca)
             {
                 String rezerwacja = "Id rezerwacji: " + res1.getIdReservation();

                chunk = new Chunk(rezerwacja, subFont);
                document.add(chunk);
                 document.add(chunk.NEWLINE);
             }
            document.close();
        }

    AirportWebClient() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();


        flights.setLayout(new GridLayout(2,5, 10,10));

        for(Flight koncert:listakon) {
            System.out.println(koncert.getCityForm());

            model.addElement(koncert.getCityForm()+" "+koncert.getCityTo()+" "+koncert.getDay()+" "+koncert.getTime());
        }
        lista = new JList(model);

        resvList1 = new JList();
        resvList1.setMaximumSize(new Dimension(100,100));

        resvList2 = new JList();
        resvList2.setMaximumSize(new Dimension(100,100));

        skrolpanel = new JScrollPane(resvList1);
        skrolpanel2 = new JScrollPane(resvList2);

        lista.addListSelectionListener(wczytajKoncert);

        flights.add(lista);

        flights.add(resLabel);
        flights.add(skrolpanel);

        rezerwuj.addActionListener(rezerwujList);
        flights.add(rezerwuj);

        flights.add(resLabel2);
        flights.add(skrolpanel2);

        flights.add(potwierdz);

        flights.add(resLabel3);

        potwierdz.addActionListener(potwierdzenie);

        flights.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        // Rezerwacje
        reservations.setLayout(new GridLayout(2,5, 10,10));

        for(Reservation reserw:listares3) {

            modelRes3.addElement("Id: "+reserw.getIdReservation()+", Lot: "+reserw.getIdFlight());

        }
        resvList3 = new JList(modelRes3);
        resvList3.setMaximumSize(new Dimension(100,100));

        resvList4 = new JList();
        resvList4.setMaximumSize(new Dimension(100,100));

        skrolpanel3 = new JScrollPane(resvList3);
        skrolpanel4 = new JScrollPane(resvList4);

        reservations.add(skrolpanel3);

        anuluj.addActionListener(anulujMiejsce);
        reservations.add(anuluj);

        innemiejsce.addActionListener(zmienMiejsce);
        reservations.add(innemiejsce);

        reservations.add(skrolpanel4);

        potwinnemiejsce.addActionListener(zmienMiejsce2);
        reservations.add(potwinnemiejsce);

        reservations.add(resLabel4);

        reservations.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        tabs.add("Baza lotów", flights);
        tabs.add("Rezerwacje", reservations);

        panel.add(tabs);

        add(panel);
        setSize(600,600);
        setVisible(true);
    }
}




