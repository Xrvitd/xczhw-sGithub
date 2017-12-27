package homework_7;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class Main {
	public static void main(String[] args)
	{
		MyPanel panel = new MyPanel();
		try
		{
			Scanner scan = new Scanner(new FileInputStream(new File("T7.in")));
			while(scan.hasNext())
			{
				String s = scan.next();
				switch (s) {
				case "L":
					panel.gra.add(new Line(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
					break;
				case "O":
					panel.gra.add(new Oval(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
					break;
				case "R":
					panel.gra.add(new Rect(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
					break;
				default:
					break;
				}
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Homework_7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		return;
	}
}
