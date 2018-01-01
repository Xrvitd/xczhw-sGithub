package jlisttest;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.event.*;

public class Main {
	public static void main(String[] args)
	{
		MyFile top = new MyFile("/Users/xczhw/FileTester");
		JScrollPane jsp = new JScrollPane();
		MyFile[] listF = top.listFiles();
		JList<String> l = new JList<String>(MyFile.getStirng(listF));
		l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount() == 2)
				{
					int index = l.locationToIndex(e.getPoint());
					MyFile clicked = listF[index];
					Desktop desk = Desktop.getDesktop();
					try {
						desk.open(clicked);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println("Double clicked on Item " + index + clicked);
					
				}
			}
		});
		l.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				int index = l.getSelectedIndex();
				MyFile clicked = listF[index];
				if(clicked.isFile())
					return;
				
			}
			
		});
		jsp.setViewportView(l);
		
		
		JPanel panel = new JPanel();
		panel.add(jsp);
		
		JFrame frame = new JFrame("haha");
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}

}
