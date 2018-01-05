package main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class List extends JList<MyFile>
{
	private static JSplitPane viewPane;
	
	private MyFile[] listF;
	private JComponent JSP;
	
	public static void setViewPane(JSplitPane jsp)
	{
		viewPane = jsp;
		return;
	}
	
	List(MyFile mf)
	{
		super(mf.listFiles());
		listF = mf.listFiles();
		addMouseListener(new MouseListener());	
		addListSelectionListener(new SelectionListener());
	}
	
	public void setMyJSP(JComponent jsp)
	{
		JSP = jsp;
	}
	
	private class MouseListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(e.getClickCount() == 2)
			{
				int index = locationToIndex(e.getPoint());
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
	}
	
	private class SelectionListener implements ListSelectionListener
	{

		public void valueChanged(ListSelectionEvent e)
		{
			int index = getSelectedIndex();
			MyFile clicked = listF[index];
			viewPane.setLeftComponent(JSP);
			if(clicked.isFile())
				return;
			if(getValueIsAdjusting())
				return;
			List l = new List(clicked);
			JScrollPane scrolP = new JScrollPane();
			scrolP.setViewportView(l);
			
			JSplitPane spliter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, JSP, scrolP);
			spliter.setOneTouchExpandable(true);
			spliter.setContinuousLayout(true);
			l.setMyJSP(spliter);
			
			viewPane.setLeftComponent(spliter);
		}
	}
}
