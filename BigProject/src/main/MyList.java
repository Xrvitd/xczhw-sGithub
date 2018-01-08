package main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class MyList extends JList<MyFile>
{
	private static JSplitPane viewPane;
	
	private MyFile[] listF;
	private JComponent JSP;
	
	public static JSplitPane getViewPane()
	{
		return viewPane;
	}
	
	public static void setViewPane(JSplitPane jsp)
	{
		viewPane = jsp;
		return;
	}
	
	public MyFile getSelected()
	{
		int len = this.getSelectedIndices().length;
		if(len > 1)
			return null;
		int index = this.getSelectedIndex();
		return listF[index];
	}
	
	MyList(MyFile mf)
	{
		super(mf.listFiles());
		listF = mf.listFiles();
		addMouseListener(new MouseListener());	
		addListSelectionListener(new SelectionListener());
		setBorder(null);
	}
	
	MyList(MyFile mf, JComponent jsp)
	{
		this(mf);
		JScrollPane scrolP = new JScrollPane();
		scrolP.setViewportView(this);
		scrolP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrolP.setBorder(null);
		//scrolP.setSize(new Dimension(200, 600));
		//scrolP.setPreferredSize(new Dimension(200,600));
		
		JSplitPane spliter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp, scrolP);
		spliter.setBorder(null);
		spliter.setDividerSize(1);
		spliter.setDividerLocation(spliter.getWidth() - 200);
		System.out.println(spliter.getHeight());
		spliter.setContinuousLayout(true);
		this.setMyJSP(spliter);
		
		viewPane.setLeftComponent(spliter);
		viewPane.setDividerLocation(viewPane.getWidth());
		System.out.println(viewPane.getLeftComponent().getWidth());
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
				if(clicked.isDirectory())
					return;
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
			viewPane.setLeftComponent(JSP);
			if(getSelectedIndices().length != 1)
				return;
			int index = getSelectedIndex();
			MyFile clicked = listF[index];
			
			if(clicked.isFile())
				return;
			if(getValueIsAdjusting())
				return;
			
			new MyList(clicked, JSP);
		}
	}
}
