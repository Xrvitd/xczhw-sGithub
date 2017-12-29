package jlisttest;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class JListtester 
{
	static void dfs(File f)
	{
		File[] fs = f.listFiles();
		if(f.isFile())
			System.out.println("<f>" + f.getName());
		else
			System.out.println("<d>" + f.getName());
		if(fs == null)
			return;
		for(File sf : fs)
			dfs(sf);
		return;
	}
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
