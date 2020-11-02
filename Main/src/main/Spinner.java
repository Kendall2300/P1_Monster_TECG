/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Daniel Montoya
 */
import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.event.*;

public class Spinner {

    public static void main(String[] args) {

        //for all the images you have
        ImageIcon icon, icon2, icon3, icon4, icon5;

        //here change image path to yours
        icon = new ImageIcon(new Object().getClass().getResource("/Cartas/10.png"));
        //here change image path to yours
        icon2 = new ImageIcon(new Object().getClass().getResource("/Cartas/25.png"));
        //here change image path to yours
        icon3 = new ImageIcon(new Object().getClass().getResource("/Cartas/3.png"));
        //here change image path to yours
        icon4 = new ImageIcon(new Object().getClass().getResource("/Cartas/9.png"));
        //here change image path to yours
        icon5 = new ImageIcon(new Object().getClass().getResource("/Cartas/30.png"));

        //to display images
        JLabel label = new JLabel();
        label.setSize(300, 300);

        //if you want a image to show when window open
        //label.setIcon(iconName);
        label.setText("Switch");

        //create a jpanel to add the all component into layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setSize(1920, 1080);
        panel.add(label);

        //using spinner model you can change to fit your requirements
        /**
        SpinnerModel model = new SpinnerNumberModel(1, // initial value
                1, // minimum value
                5, // maximum value
                1); // step
        */
        
        SpinnerModel model = new SpinnerNumberModel(1,1,5,1); // step
        //create new spinner according to model that we create above
        JSpinner spinner = new JSpinner(model);
        spinner.setBounds(800, 800, 50, 30);

        //crete jframe and add that panel we create before
        JFrame f = new JFrame("Change images from spinner");
        f.add(panel);
        panel.add(spinner);

        f.setSize(1920, 1080);
        f.setLayout(null);
        f.setVisible(true);

        //To change images when changing values add ChangeListener
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                //when number changed get that number and convert into integer
                int count = Integer.parseInt("" + ((JSpinner) e.getSource()).getValue());

                //when spinner values change you can check using count and place image you want
                if (count == 1) {
                    label.setIcon(icon);//set image to jLabel
                } else if (count == 2) {
                    label.setIcon(icon2);
                } else if (count == 3) {
                    label.setIcon(icon3);
                } else if (count == 4) {
                    label.setIcon(icon4);
                } else if (count == 5) {
                    label.setIcon(icon5);
                }
            }
        });

    }
}