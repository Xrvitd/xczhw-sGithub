package main;

import javax.swing.*;

public class MyFrame {

	MyFrame(MyFile top)
	{
		MyList l = new MyList(top);
		JScrollPane lAdder = new JScrollPane();
		lAdder.setBorder(null);
		lAdder.setViewportView(l);
		lAdder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lAdder, new JPanel());
		jsp.setBorder(null);
		jsp.setDividerLocation(200);
		jsp.setContinuousLayout(true);
		jsp.setDividerSize(1);
		l.setMyJSP(lAdder);
		MyList.setViewPane(jsp);
		JScrollPane adder = new JScrollPane();
		adder.setViewportView(jsp);
		
		JFrame frame = new JFrame("haha");
		frame.getContentPane().add(adder);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}
}
