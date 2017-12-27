package homework_8;

import java.awt.*;
import java.util.Stack;

import javax.swing.*;

public class MyPanel extends JPanel
{
	int n;
	static final int PRE_NUM_BRICK_LENGTH = 50;
	static final int PRE_BRICK_HEIGHT = 30;
	int MAX_BRICK_LENGTH;
	Stack <Brick> [] tow;
	MyPanel(int n, Stack <Brick> [] tow)
	{
		this.n = n;
		this.tow = tow;
		this.MAX_BRICK_LENGTH = n * MyPanel.PRE_NUM_BRICK_LENGTH;
		int doubleLength = PRE_NUM_BRICK_LENGTH + MAX_BRICK_LENGTH / 2 << 1;
		setPreferredSize(new Dimension(doubleLength * 3 + doubleLength / 2,PRE_BRICK_HEIGHT * (n + 3)));
		return;
	}
	
	void draw(Brick b,Graphics page,int x,int y)
	{
		int length = PRE_NUM_BRICK_LENGTH + MAX_BRICK_LENGTH / 2;
		page.setColor(Color.GRAY);
		page.fillRect(length * (x * 2 + 1) - (PRE_NUM_BRICK_LENGTH * b.num) / 2, PRE_BRICK_HEIGHT * (n - y + 1), PRE_NUM_BRICK_LENGTH * b.num, PRE_BRICK_HEIGHT);
		page.setColor(Color.BLACK);
		page.drawRect(length * (x * 2 + 1) - (PRE_NUM_BRICK_LENGTH * b.num) / 2, PRE_BRICK_HEIGHT * (n - y + 1), PRE_NUM_BRICK_LENGTH * b.num, PRE_BRICK_HEIGHT);
	}
	
	public void paintComponent(Graphics page)
	{
		int length = PRE_NUM_BRICK_LENGTH + MAX_BRICK_LENGTH / 2;
		int doubleLength = length * 2;
		for(int i = 0;i < 3;i ++)
			page.drawLine(length * (i * 2 + 1), PRE_BRICK_HEIGHT * (n + 2), length * (i * 2 + 1), PRE_BRICK_HEIGHT * 1);
		page.drawLine(0, PRE_BRICK_HEIGHT * (n + 2), doubleLength * 3 + doubleLength / 2, PRE_BRICK_HEIGHT * (n + 2));
		for(int i = 0;i < tow.length;i ++)
		{
			for(int j = 0;j < tow[i].size();j ++)
			{
				Brick b = tow[i].get(j);
				draw(b,page,i,j);
			}
		}
	}
}
