package homework_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Comparable<Student>
{
	String name,num;
	Double xf,xfcj;
	Double GPA;
	
	Student(String num,String name)
	{
		this.num = num;
		this.name = name;
		xf = new Double(0.0);
		xfcj = new Double(0.0);
		GPA = new Double(0.0);
		return;
	}
	
	public void add(Class c,Integer fs)
	{
		xf += c.xf;
		xfcj += c.xf * fs;
		return;
	}
	
	public int compareTo(Student o)
	{
		if(this.GPA.equals(o.GPA))
			return 0;
		return (this.GPA - o.GPA) < 0.0 ? 1 : -1;
		
	}
	
	void getGPA()
	{
		GPA = xfcj / xf;
		return;
	}
	
	static boolean find(String s,ArrayList<Student> stu)
	{
		for(Student st : stu)
			if(st.num.equals(s))
				return true;
		return false;
	}
	
	static void scan(Scanner s,ArrayList<Student> stu)
	{
		while(s.hasNext())
		{
			String num = s.next();
			String name = s.next();
			if(find(num,stu))
				continue;
			stu.add(new Student(num,name));
		}
		return;
	}
	
	static Student findStu(String s,ArrayList<Student> stu)
	{
		for(Student st : stu)
			if(st.num.equals(s))
				return st;
		return null;
	}

	public void out() {
		System.out.println(name + " " + GPA);
	}

}