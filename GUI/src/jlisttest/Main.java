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
		List l = new List(top);
		JScrollPane lAdder = new JScrollPane();
		lAdder.setViewportView(l);
		JSplitPane smalljsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, null, lAdder);
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, smalljsp, null);
		jsp.setOneTouchExpandable(true);
		l.setMyJSP(smalljsp);
		List.setViewPane(jsp);
		
		
		JFrame frame = new JFrame("haha");
		frame.getContentPane().add(jsp);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}

}
