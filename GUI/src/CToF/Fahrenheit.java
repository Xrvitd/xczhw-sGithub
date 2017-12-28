package CToF;

import javax.swing.*;

public class Fahrenheit {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("......");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FahrenheitPanel panel = new FahrenheitPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		return;
	}
}
