package jlisttest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class List extends JList<MyFile>
{
	private MyFile[] listF;
	private JSplitPane lastJSP;
	
	List(MyFile mf)
	{
		super(mf.listFiles());
		listF = mf.listFiles();
		addMouseListener(new MouseListener());	
		addListSelectionListener(new SelectionListener());
	}
	
	List(MyFile mf, JSplitPane jsp)
	{
		this(mf);
		if(jsp == null)
			jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this, null);
		lastJSP = jsp;
	}
	
	public void setMyJSP(JSplitPane jsp)
	{
		lastJSP = jsp;
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
			if(clicked.isFile())
				return;
			if(getValueIsAdjusting())
				return;
			List l = new List(clicked,lastJSP);
			JScrollPane scrolP = new JScrollPane();
			scrolP.setViewportView(l);
			JSplitPane jsp = (JSplitPane) lastJSP.getLeftComponent();
			JSplitPane spliter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp, scrolP);
			spliter.setOneTouchExpandable(true);
			spliter.setContinuousLayout(true);
			lastJSP.setLeftComponent(spliter);
			lastJSP = jsp;
		}
	}
}
