package main;

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
		MyFrame frame = new MyFrame(top);
	}

}
