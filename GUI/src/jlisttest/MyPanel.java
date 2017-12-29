package jlisttest;

import java.awt.*;
import java.io.File;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyPanel extends JPanel
{
	public void paintComponent(Graphics page)
	{
		File top = new File("/Users/xczhw/FileTester");
		JList l = new JList(top.listFiles());
		l.addListSelectionListener(new ListListener());
	}
	private class ListListener implements ListSelectionListener
	{

		public void valueChanged(ListSelectionEvent e) {
			
		}
		
	}
}
