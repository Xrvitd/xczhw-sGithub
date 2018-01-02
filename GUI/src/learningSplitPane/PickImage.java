package learningSplitPane;

import java.awt.*;
import jlisttest.MyFile;
import javax.swing.*;

public class PickImage
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Pick Image");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JLabel imageLabel = new JLabel();
		JPanel imagePanel = new JPanel();
		imagePanel.add (imageLabel);
		imagePanel.setBackground (Color.white);
		
		ListPanel imageList = new ListPanel (imageLabel);  
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
										imageList, imagePanel);
		
		sp.setOneTouchExpandable (true);
		
		frame.getContentPane().add (sp);
		frame.pack();
		frame.setVisible(true);
	}
}
