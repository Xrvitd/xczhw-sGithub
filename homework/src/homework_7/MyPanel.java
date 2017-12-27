package homework_7;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel
{
	ArrayList <Graph> gra;
	MyPanel()
	{
		gra = new ArrayList <Graph>();
		
		setPreferredSize(new Dimension(3000,2000));
	}
	public void paintComponent(Graphics page)
	{
		for(Graph g : gra)
			g.draw(page);
		return;
	}
}
