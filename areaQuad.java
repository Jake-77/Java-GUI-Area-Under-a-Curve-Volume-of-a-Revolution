package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by 73632LAM on 19/01/2018.
 */
public class areaQuad extends JFrame {

    private double D1;
    private double D2;
    private double N;
    private double a;
    private double h;
    private double c;
    private double Gx;
    private double areaQ;
    String answer;

    public void ResetData () {

        D1 = 0;
        D2 = 0;
        N = 0;
        a = 0;
        h = 0;
        c = 0;
        Gx = 0;
        areaQ = 0;

    }

    public areaQuad () {

        //setVisible(true);
        setSize(375, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Enter a value for each part of the Quadratic function");
        heading.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel variableOne = new JLabel("Enter the value of a:");
        JTextField aValue = new JTextField(12);

        JLabel variableTwo = new JLabel("Enter the value of h:");
        JTextField hValue = new JTextField(12);

        JLabel variableThreeTwo = new JLabel("Enter the value of c:");
        JTextField cValue = new JTextField(12);

        JLabel variableThree = new JLabel("Enter the lower bound of the domain):");
        JTextField domain1 = new JTextField(12);

        JLabel variableFour = new JLabel("Enter the upper bound of the domain:");
        JTextField domain2 = new JTextField(12);

        JLabel variableFive = new JLabel("Enter the amount of rectangles you would like to use):");
        JTextField slices = new JTextField(12);

        JLabel variableSix = new JLabel("Enter the y value for the function (Gx)");
        JTextField gOfX = new JTextField (12);

        JButton calculate = new JButton("Calculate");

        //JLabel volumeIs = new JLabel("The volume is:");
        //JTextField answer = new JTextField(12);

        setLayout(new FlowLayout());

        add(heading);
        add(variableOne);
        add(aValue);
        add(variableTwo);
        add(hValue);
        add (variableThreeTwo);
        add (cValue);
        add(variableThree);
        add(domain1);
        add(variableFour);
        add(domain2);
        add(variableFive);
        add(slices);
        add (variableSix);
        add (gOfX);
        add(calculate);
        //add (volumeIs);
        //add(answer);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                a = Double.parseDouble(aValue.getText());
                h = Double.parseDouble(hValue.getText());
                c = Double.parseDouble(cValue.getText());
                D1 = Double.parseDouble(domain1.getText());
                D2 = Double.parseDouble(domain2.getText());
                N = Double.parseDouble(slices.getText());
                Gx = Double.parseDouble(gOfX.getText());

                calculations();
                JOptionPane.showMessageDialog(null, String.valueOf(areaQ));
                ResetData();
                //answer = JOptionPane.showInputDialog("The functions Area is:" + String.valueOf(areaQ));
                //answer.setText(String.valueOf(areaQ));
            }
        });
    }


    public Double calculations () {

        double Swidth;
        double Sheight;
        double areaQS;
        double X;
        //in method variables needed to calculate the definite integral of a Quadratic curve

        Swidth = Math.abs((D2 - D1) / N);
        //This finds the width of the rectangle slices, each rectangle has the same width

        for (int i = 0; i <= N; i++) {
            //The loop is needed so that we can find the area of each rectangle since it loops as many times as the number of slices the user input

            X = D1 + i * Swidth;
            //This finds the x value at the start of each rectangle in the domain on the quadratic curve

            Sheight = Math.abs(a * (( X - h ) * ( X - h )) + c - Gx);
            //The height of a rectangle is equal to the function at the start of each rectangles x value
            //Subtract G(x) from c in order to take in to account the Gx line to adjust the height of the area

            areaQS = Swidth * Sheight;
            //the area of one rectangle width (base) * height

            areaQ += areaQS;

        }

        return  areaQ;

    }
}

