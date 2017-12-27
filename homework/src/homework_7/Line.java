package homework_7;

import java.awt.*;

public class Line extends Graph
{
	int x1,y1,x2,y2;
	Line(int x1,int y1,int x2,int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		return;
	}
	void draw(Graphics page)
	{
		page.drawLine(x1, y1, x2, y2);
	}
}
