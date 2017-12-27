package homework_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Class
{
	String num,name;
	Double xf;
	
	Class(String num,String name,Double xf)
	{
		this.num = num;
		this.name = name;
		this.xf = xf;
		return;
	}
	
	static boolean find(String num,ArrayList<Class> cla)
	{
		for(Class cl : cla)
			if(cl.num.equals(num))
				return true;
		return false;
	}
	
	static void scan(Scanner c,ArrayList<Class> cla)
	{
		while(c.hasNext())
		{
			String num = c.next();
			String name = c.next();
			if(find(num,cla))
				continue;
			Double xf = c.nextDouble();
			cla.add(new Class(num,name,xf));
		}
		return;
	}
	
	static Class findCla(String s,ArrayList<Class> cla)
	{
		for(Class cl : cla)
			if(cl.num.equals(s))
				return cl;
		return null;
	}
}

