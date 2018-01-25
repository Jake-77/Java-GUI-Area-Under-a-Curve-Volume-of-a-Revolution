package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 73632LAM on 16/01/2018.
 */

public class volumeOfRevolution extends JFrame {

    private double D1;
    private double D2;
    private double S;
    private double M;
    private double B;
    private double Fx = 0;
    private double Volume;
    String answer;
    String warning;

    public volumeOfRevolution() {

        //setVisible(true);
        setSize(450, 225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Enter a value for each part of the Linear function");
        heading.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel variableOne = new JLabel("Enter the value for  slope of the function (m):");
        JTextField slope = new JTextField(12);

        JLabel variableTwo = new JLabel("Enter your functions y-intercept:");
        JTextField yIntercept = new JTextField(12);

        JLabel variableThree = new JLabel("Enter the lower bound of the domain):");
        JTextField domain1 = new JTextField(12);

        JLabel variableFour = new JLabel("Enter the upper bound of the domain:");
        JTextField domain2 = new JTextField(12);

        JLabel variableFive = new JLabel("Enter the amount of shells you would like to use):");
        JTextField slices = new JTextField(12);

        JButton calculate = new JButton("Calculate");

        //JLabel volumeIs = new JLabel("The volume is:");

        //JTextField answer = new JTextField(12);

        setLayout(new FlowLayout());

        add(heading);
        add(variableOne);
        add(slope);
        add(variableTwo);
        add(yIntercept);
        add(variableThree);
        add(domain1);
        add(variableFour);
        add(domain2);
        add(variableFive);
        add(slices);
        add(calculate);
        //add (volumeIs);
        //add(answer);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                M = Double.parseDouble(slope.getText());
                B = Double.parseDouble(yIntercept.getText());
                D1 = Double.parseDouble(domain1.getText());

                if (D1 < 0) {
                     warning = JOptionPane.showInputDialog("Invalid domain 1 input, domain 1 must be greater or equal to 0");
                     D1 = Double.parseDouble(warning);
                }

                D2 = Double.parseDouble(domain2.getText());

                if (D2 <= D1) {
                    warning = JOptionPane.showInputDialog("Invalid domain 2 input, domain 2 must be greater than domain 1");
                    D2 = Double.parseDouble(warning);
                }

                S = Double.parseDouble(slices.getText());

                if (S <= 0) {
                    warning = JOptionPane.showInputDialog("Invalid slice number input, amount of slices must be greater than 0");
                    S = Double.parseDouble(warning);
                }

                calculations();

                JOptionPane.showMessageDialog(null, "The functions volume of a revolution is:" + String.valueOf(Volume));
                //answer.setText(String.valueOf(Volume));
            }
        });

    }

    private Double calculations() {

        double Swidth;
        double twoPie;
        double radius;
        double Sheight;
        double Sarea;
        double Svolume;

        Swidth = (D2 - D1) / S;
        // Shell width finds the width of the shells (all are the same) using the difference between the two domains divided by the amount of shells

        twoPie = 2 * Math.PI;
        // calculation in java two represent the radian 2 pie

        for (int i = 0; i <= S; i++) {
            // this for loop goes over this method until the counter hits the number of shells

            radius = D1 + (i * Swidth);
            // the radius is calculated by adding domain1 to the current shell times the width of the shell as the radius is equal to the distance from domain1 to the current shell

            Sheight = (M * radius + B) - Fx;
            //The height of the value of y at the start of each shell is the height of the shell

            Sarea = Sheight * Swidth;
            //Part of the volume formula just split up by first calculating the area of a shell in 2D

            Svolume = twoPie * radius * Sarea;
            //This is the formula for the volume of one shell

            Volume += Svolume;
        }
        return Volume;
    }
}

