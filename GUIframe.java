package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert Hubert on 21/12/2017.
 */

public class GUIframe extends JFrame {

    final int F_WIDTH   =  300;
    final int F_HEIGHT  =  150;

    public static String name;

    chooseMethod choose = new chooseMethod();

    public GUIframe (){

        super("JFrame Many Components");

        setSize(F_WIDTH,F_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Here is our heading

        JLabel heading = new JLabel("Welcome to my Calculator");

        heading.setFont( new Font("Arial", Font.BOLD, 14));
        // Here is our prompt

        JLabel promptName =  new JLabel("Please enter your name: ");

        // Here is our text field
        JTextField nameField = new JTextField(12);

        //name = nameField.getText();

        // Here is our button
        JButton button = new JButton("Click to Continue");

        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(promptName);
        add(nameField);
        add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                choose.setVisible(true);
                dispose();
            }
        });
    }
}
