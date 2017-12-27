package homework_7;

import java.awt.Graphics;

public class Oval extends Graph
{
	int x,y,width,height;
	Oval(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void draw(Graphics page)
	{
		page.drawOval(x, y, width, height);
	}
}
