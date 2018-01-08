package main;

import java.awt.Color;

public class Tag {
	String name;
	int index;
	Color c;
	Tag(String nam, int ind, Color col)
	{
		name = nam;
		index = ind;
		c = col;
	}
	
	public boolean equals(Tag t)
	{
		return name.equals(t.name);
	}
	
	public void setName(String s)
	{
		name = s;
	}
	
	public String toString()
	{
		return name;
	}
	
	public void setColor(Color col)
	{
		c = col;
	}
}
