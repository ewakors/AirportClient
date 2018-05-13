package com.client;

import com.ws.Flight;
import com.ws.AirportServiceService;
import com.ws.Reservation;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import com.ws.AirportService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AirportWebClient extends JFrame {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);

    String concertName;

    JPanel flightsPanel = new JPanel();
    JPanel reservationsPanel = new JPanel();

    JButton rezerwuj = new JButton("Kup bilet");
    JButton potwierdz = new JButton("Potwierdź kupno biletu");

    JTabbedPane tabs = new JTabbedPane();

    static AirportServiceService mss;
    static AirportService ms;

    static List<Flight> flightsList;
    static List<Reservation> reservationsList;


    DefaultTableModel flightTable;
    DefaultTableModel flightReservationsTable;
    JTable jTableFlights;
    JTable jTableReservations;
    private TableRowSorter<TableModel> rowSorter;
    private JTextField jtfFilter = new JTextField();
    
    private JTextField searchReservationTF = new JTextField();
     private TableRowSorter<TableModel> reservationRowSorter;

    int reservationId = 0;
    
    JScrollPane flightsScrollPane;
    JScrollPane reservationsScrollPane;

    ActionListener potwierdzenie = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        
            jTableReservations.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            System.out.println(jTableReservations.getValueAt(jTableReservations.getSelectedRow(), 0).toString());
        }
    });

            
        }
    };
    
    public static void main(String[] args) throws IOException, DocumentException, Exception {

        mss = new AirportServiceService();
        ms = mss.getAirportServicePort();

        flightsList = new ArrayList<>();
        flightsList = ms.getFlightList();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AirportWebClient();
            }
        });

    }

    public void generatePDF(String reservationId) throws FileNotFoundException, DocumentException {

        DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

        String nazwapliku = "/Users/ewa/Downloads/AirportClient/Rezerwacja" + dateFormat.format(date) + ".pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(nazwapliku));

        document.open();
        com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Chunk chunk = new Chunk("Potwierdzenie kupna lotu", catFont);

        Paragraph para = new Paragraph("Lot", catFont);

        document.add(para);

        document.add(chunk.NEWLINE);
        document.add(chunk.NEWLINE);

        
            String rezerwacja = "Numer rezerwacji: " + reservationId;

            chunk = new Chunk(rezerwacja, subFont);
            document.add(chunk);
            document.add(chunk.NEWLINE);
        
        document.close();
    }

    AirportWebClient() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JPanel searchPanel = new JPanel(new BorderLayout()); 
        JPanel reservationSearchPanel = new JPanel(new BorderLayout());
        
        flightTable = new DefaultTableModel();

        searchPanel.add(new JLabel("Wyszukiwanie lotów:"), BorderLayout.NORTH);
        searchPanel.add(jtfFilter);
        jtfFilter.setPreferredSize(new Dimension(200, 22));

        flightTable.addColumn("Lot z");
        flightTable.addColumn("Lot do");
        flightTable.addColumn("Dzień");
        flightTable.addColumn("Godzina");

        for (Flight flight : flightsList) {

            Object[] object = new Object[4];
            object[0] = flight.getCityForm();
            object[1] = flight.getCityTo();
            object[2] = flight.getDay();
            object[3] = flight.getTime();
            flightTable.addRow(object);

            System.out.println("city from " + flight.getCityForm());
        }
        jTableFlights = new JTable(flightTable);
        rowSorter = new TableRowSorter<>(jTableFlights.getModel());
        jTableFlights.setRowSorter(rowSorter);
        
       

        flightReservationsTable = new DefaultTableModel();
        
        flightReservationsTable.addColumn("Id rezerwacji");
        flightReservationsTable.addColumn("Lot z");
        flightReservationsTable.addColumn("Lot do");
        flightReservationsTable.addColumn("Dzień");
        flightReservationsTable.addColumn("Godzina");
        jTableReservations = new JTable(flightReservationsTable);

        //search flights
        jtfFilter.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        //search reservation
        searchReservationTF.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchReservationTF.getText();

                if (text.trim().length() == 0) {
                    reservationRowSorter.setRowFilter(null);
                } else {
                    reservationRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchReservationTF.getText();

                if (text.trim().length() == 0) {
                    reservationRowSorter.setRowFilter(null);
                } else {
                    reservationRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        JPanel buttonPanel = new JPanel(new BorderLayout());

        rezerwuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_rowsActionPerformed(evt);
            }

            private void jButton_add_rowsActionPerformed(ActionEvent evt) {
                
                TableModel model1 = jTableFlights.getModel();
                int[] indexs = jTableFlights.getSelectedRows();
                Object[] row = new Object[5];
                DefaultTableModel model2 = (DefaultTableModel) jTableReservations.getModel();
                
                 reservationRowSorter = new TableRowSorter<>(jTableReservations.getModel());
        jTableReservations.setRowSorter(reservationRowSorter);
        
                for (int i = 0; i < indexs.length; i++) {
                    row[0] = reservationId;
                    row[1] = model1.getValueAt(indexs[i], 0);
                    row[2] = model1.getValueAt(indexs[i], 1);
                    row[3] = model1.getValueAt(reservationId, 2);
                    row[4] = model1.getValueAt(indexs[i], 3);
                    
                    model2.addRow(row);
                }
                reservationId++;
            }
        });

        buttonPanel.add(rezerwuj);
        
         potwierdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton_add_rowsActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AirportWebClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(AirportWebClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void jButton_add_rowsActionPerformed(ActionEvent evt) throws FileNotFoundException, DocumentException {
                generatePDF(jTableReservations.getValueAt(jTableReservations.getSelectedRow(), 0).toString());
System.out.println(jTableReservations.getValueAt(jTableReservations.getSelectedRow(), 0).toString());
            }
        });

        tabs.add("Baza lotów", flightsPanel);
        tabs.add("Rezerwacje", reservationsPanel);
        panel.add(tabs);

        flightsPanel.setLayout(new GridLayout(2, 2));
        flightsScrollPane = new JScrollPane(jTableFlights);
        flightsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        flightsPanel.add(searchPanel,BorderLayout.NORTH);
        flightsPanel.add(flightsScrollPane,BorderLayout.CENTER);
        flightsPanel.add(buttonPanel,BorderLayout.SOUTH);
        
        

        potwierdz.addActionListener(potwierdzenie);
        reservationsScrollPane = new JScrollPane(jTableReservations);
        reservationsPanel.add(searchReservationTF, BorderLayout.CENTER);
        reservationsPanel.add(reservationsScrollPane, BorderLayout.CENTER);
        reservationsPanel.add(potwierdz, BorderLayout.CENTER);
        reservationsPanel.setLayout(new GridLayout(2, 2));

        add(panel);

        setSize(1200, 800);
        setVisible(true);
        setLayout(new GridLayout());
    }
}
