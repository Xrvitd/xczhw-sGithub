package homework_7;

import java.awt.Graphics;

public class Rect extends Graph
{
	int x,y,width,height;
	Rect(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void draw(Graphics page)
	{
		page.drawRect(x, y, width, height);
	}
}
