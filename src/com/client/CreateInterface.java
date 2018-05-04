package com.client;

import com.ws.Flight;

import javax.swing.*;
import java.util.List;

public class CreateInterface {
    private JPanel panelMain;
    private JTabbedPane tabbedPane1;
    private JPanel conTab;
    private JPanel resTab;
    private JList concertJlist;
    private JLabel label1;
    private JFrame frame;
    private List<Flight> concertlist;

    DefaultListModel model;


    public void Update(String name) {

        label1.setText(name);

        //label1.revalidate();

        panelMain.invalidate();


    }


    public CreateInterface() {



    }

    public void SetInterface(List<Flight> concertlist2) {

        this.concertlist = concertlist2;

        frame = new JFrame("CreateInterface");
        frame.setContentPane(new CreateInterface().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Nazwa");

        concertlist = concertlist2;





    }

}
