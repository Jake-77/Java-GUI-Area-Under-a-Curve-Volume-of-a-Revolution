package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 73632LAM on 18/01/2018.
 */
public class areaLinear extends JFrame{

    private double D1;
    private double D2;
    private double N;
    private double m;
    private double b;
    private double Gx;
    private double areaL;
    String answer;

    public void ResetData () {

        D1 = 0;
        D2 = 0;
        N = 0;
        m = 0;
        b = 0;
        Gx = 0;
        areaL = 0;

    }

    public areaLinear () {

        //setVisible(true);
        setSize(500, 250);
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
        add(slope);
        add(variableTwo);
        add(yIntercept);
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

                m = Double.parseDouble(slope.getText());
                b = Double.parseDouble(yIntercept.getText());
                D1 = Double.parseDouble(domain1.getText());
                D2 = Double.parseDouble(domain2.getText());
                N = Double.parseDouble(slices.getText());
                Gx = Double.parseDouble(gOfX.getText());

                calculations();
                JOptionPane.showMessageDialog(null, "The functions Area is:" + String.valueOf(areaL));
                ResetData();
                //answer = JOptionPane.showInputDialog("The functions Area is:" + String.valueOf(areaL));
                //answer.setText(String.valueOf(areaL));
            }
        });

    }

    public Double calculations () {

        double Swidth;
        double Sheight;
        double areaLS;
        double X;
        //in method variables needed to calculate the definite integral of a linear line

        Swidth = Math.abs((D2 - D1) / N);
        //This finds the width of the rectangle slices, each rectangle has the same width

        for (int i = 0; i <= N; i++) {
            //The loop is needed so that we can find the area of each rectangle since it loops as many times as the number of slices the user input

            X = Math.abs(D1 + i * Swidth);
            //This finds the x value at the start of each rectangle on the y = mx + b line

            Sheight = Math.abs((m * X) + (b - Gx));
            //The height of the rectangle is equal to the function at the start of each rectangles x value
            //Subtract G(x) from b in order to take in to account the Gx line to adjust the height of the area

            areaLS = Swidth * Sheight;
            //the area of one rectangle width (base) * height

            areaL += areaLS;

        }

        return areaL;
    }

}

