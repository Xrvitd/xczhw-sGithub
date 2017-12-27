package homework_8;

import java.util.*;
import javax.swing.JFrame;

public class Mover {
	Stack <Brick> [] tow = new Stack [3];
	MyPanel panel;
	Mover(int n)
	{
		for(int i = 0;i < tow.length;i ++)
			tow[i] = new Stack<Brick>();
		for(int i = n;i >= 1;i --)
			tow[0].add(new Brick(i));
		
		panel = new MyPanel(n, tow);
		JFrame frame = new JFrame("Tower");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		try
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return;
	}
	
	void move(int f,int t)
	{
		Brick x = tow[f].peek();
		tow[f].pop();
		tow[t].push(x);
		panel.repaint();
		try
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return;
	}
	
	void dfs(int x,int a,int b,int c)
	{
		if(x == 0)
			return;
		dfs(x - 1,a,c,b);
		move(a,c);
		dfs(x - 1,b,a,c);
	}
	
}
