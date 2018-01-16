package.com.company

import javax.swing.Jframe;
import javax.swing.WindowConstants;

public class frameOne {

public static void main(String args[]){

JFrame frame1 = new JFrame ("my first frame");

frame1.setVisible (true);

frame1.setSize (500, 500);

frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
