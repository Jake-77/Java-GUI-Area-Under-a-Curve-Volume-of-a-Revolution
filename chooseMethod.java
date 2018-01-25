package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by 73632LAM on 18/01/2018.
 */
public class chooseMethod extends JFrame{

    areaChoose areaC = new areaChoose();
    volumeOfRevolution volumeC = new volumeOfRevolution();

    public chooseMethod () {

        //setVisible(true);
        setSize(650,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Would you like to Calculate Area Under a Curve or Volume of a revolution for a function");

        heading.setFont( new Font("Arial", Font.BOLD, 14));

        JButton area = new JButton("Area Under a Curve");
        JButton volume = new JButton("Volume of a Revolution");

        setLayout(new FlowLayout());

        add (heading);
        add (area);
        add (volume);

        area.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaC.setVisible(true);
                dispose();
            }
        });
        volume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volumeC.setVisible(true);
                dispose();
            }
        });
    }
}
