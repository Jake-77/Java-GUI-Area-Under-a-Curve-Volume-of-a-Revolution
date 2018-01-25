package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by 73632LAM on 18/01/2018.
 */
public class areaChoose extends JFrame {

    areaLinear areaL = new areaLinear();
    areaQuad areaQ = new areaQuad();
    areaSine areaS = new areaSine();
    areaCosine areaC = new areaCosine();

    public areaChoose () {

        //setVisible(true);
        setSize(600,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("What kind of function do you want to calculate the Area under the curve of");
        heading.setFont( new Font("Arial", Font.BOLD, 14));

        JButton Linear = new JButton("Linear Function");

        JButton Quadratic = new JButton("Quadratic Function");

        JButton Sine = new JButton("Sine Function");

        JButton Cosine = new JButton("Cosine Function");

        setLayout(new FlowLayout());

        add (heading);
        add (Linear);
        add (Quadratic);
        add (Sine);
        add (Cosine);

        Linear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaL.setVisible(true);
                dispose();
            }
        });

        Quadratic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaQ.setVisible(true);
                dispose();
            }
        });

        Sine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaS.setVisible(true);
                dispose();
            }
        });

        Cosine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaC.setVisible(true);
                dispose();
            }
        });

    }
}