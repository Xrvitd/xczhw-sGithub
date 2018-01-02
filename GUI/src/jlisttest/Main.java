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
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lAdder, null);
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp, null);
		jsp.setOneTouchExpandable(true);
		l.setMyJSP(jsp);
		
		
		JFrame frame = new JFrame("haha");
		frame.getContentPane().add(jsp);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}

}
