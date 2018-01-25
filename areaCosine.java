package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 73632LAM on 19/01/2018.
 */
public class areaCosine extends JFrame {

    private double D1;
    private double D2;
    private double N;
    private double a;
    private double k;
    private double c;
    private double d;
    private double Gx;
    private double areaC;
    private boolean choice;
    String answer;

    public void ResetData () {

        D1 = 0;
        D2 = 0;
        N = 0;
        a = 0;
        k = 0;
        c = 0;
        d = 0;
        Gx = 0;
        areaC = 0;

    }

    public areaCosine () {

        //setVisible(true);
        setSize(360, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Enter a value for each part of the Cosine function");
        heading.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel variableOne = new JLabel("Enter the value of a:");
        JTextField aValue = new JTextField(12);

        JLabel variableTwo = new JLabel("Enter the value of k:");
        JTextField kValue = new JTextField(12);

        JLabel variableThreeTwo = new JLabel("Enter the value of c:");
        JTextField cValue = new JTextField(12);

        JLabel variable3 = new JLabel("Enter the value of d:");
        JTextField dValue = new JTextField(12);

        JLabel variableThree = new JLabel("Enter the lower bound of the domain):");
        JTextField domain1 = new JTextField(12);

        JLabel variableFour = new JLabel("Enter the upper bound of the domain:");
        JTextField domain2 = new JTextField(12);

        JLabel variableFive = new JLabel("Enter the amount of rectangles you would like to use):");
        JTextField slices = new JTextField(12);

        JLabel variableSix = new JLabel("Enter the y value for the function (Gx)");
        JTextField gOfX = new JTextField (12);

        JRadioButton degrees = new JRadioButton("radians");
        JRadioButton radians = new JRadioButton("degrees");

        ButtonGroup radioButtons = new ButtonGroup();

        radioButtons.add(degrees);
        radioButtons.add(radians);

        JButton calculate = new JButton("Calculate");

        //JLabel volumeIs = new JLabel("The area is:");
        //JTextField answer = new JTextField(12);

        setLayout(new FlowLayout());

        add(heading);
        add(variableOne);
        add(aValue);
        add(variableTwo);
        add(kValue);
        add (variableThreeTwo);
        add (cValue);
        add (variable3);
        add (dValue);
        add(variableThree);
        add(domain1);
        add(variableFour);
        add(domain2);
        add(variableFive);
        add(slices);
        add (variableSix);
        add (gOfX);

        add (degrees);
        add (radians);

        add(calculate);
        //add (volumeIs);
        //add(answer);

        degrees.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                choice = true;

            }
        });

        radians.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                choice = false;

            }
        });

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                a = Double.parseDouble(aValue.getText());
                k = Double.parseDouble(kValue.getText());
                c = Double.parseDouble(cValue.getText());
                d = Double.parseDouble(dValue.getText());
                D1 = Double.parseDouble(domain1.getText());
                D2 = Double.parseDouble(domain2.getText());
                N = Double.parseDouble(slices.getText());
                Gx = Double.parseDouble(gOfX.getText());

                calculations();
                JOptionPane.showMessageDialog(null, "The functions Area is:" + String.valueOf(areaC));
                ResetData();
                //answer = JOptionPane.showInputDialog("The functions Area is:" + String.valueOf(areaC));
                //answer.setText(String.valueOf(areaC));
            }


        });

    }


    public Double calculations () {

        double Swidth;
        double Sheight;
        double areaCS;
        double theda;
        //in method variables needed to calculate the definite integral of a Sinusoidal wave(COSINE)

        Swidth = Math.abs((D2 - D1) / N);
        //This finds the width of the rectangle slices, each rectangle has the same width

        if (choice) {
            //this if, else statement is to allow the user to choose if they would like the cosine function to be in radians or degrees
            //In the main if the user types true they get degrees and if false they get radians

            for (int i = 0; i <= N; i++) {
                //The loop is needed so that we can find the area of each rectangle since it loops as many times as the number of slices the user input

                theda = D1 + i * Swidth;
                //This finds the x value at the start of each rectangle in the domain on the sinusoidal wave (Cosine)

                theda = Math.toDegrees(theda);
                //this changes the x value or theta in a Cosine function to degrees

                Sheight = Math.abs(a * (Math.cos(k * (theda - c))) + d - Gx);
                //The height of a rectangle is equal to the function value at the start of each rectangles x value
                //Subtract G(x) from d in order to take in to account the Gx line to adjust the height of the area

                areaCS = Swidth * Sheight;
                //the area of one rectangle width (base) * height

                areaC += areaCS;

            }

            return areaC;

        }
        else {

            for (int i = 0; i <= N; i++) {

                theda = D1 + i * Swidth;

                theda = Math.toRadians(theda);
                //this changes the x value or theta in a Cosine function to degrees

                Sheight = Math.abs(a * (Math.cos(k * (theda - c))) + d - Gx);

                areaCS = Swidth * Sheight;

                areaC += areaCS;

            }

            return areaC;



        }

    }
}