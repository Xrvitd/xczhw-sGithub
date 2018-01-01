package jlisttest;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Main {
	public static void main(String[] args)
	{
		File top = new File("/Users/xczhw/FileTester");
		JScrollPane jsp = new JScrollPane();
		File[] listF = top.listFiles();
		JList<File> l = new JList<File>(listF);
		l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount() == 2)
				{
					int index = l.locationToIndex(e.getPoint());
					System.out.println("Double clicked on Item " + index + listF[index]);// + clicked);
				}
			}
		});
		jsp.setViewportView(l);
		
		
		JPanel panel = new JPanel();
		panel.add(jsp);
		
		JFrame frame = new JFrame("haha");
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setSize(350, 350);
	}
	private class mls extends MouseAdapter
	{
		
	}
}
