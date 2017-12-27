package homework_6;

import java.util.ArrayList;

import homework_5.Student;

public abstract class Person implements Comparable<Person>
{
	String num,name;
	Integer age;
	Person(String n,String na,Integer ag)
	{
		num = n;
		name = na;
		age = ag;
		return;
	}
	abstract int getCompareVaue();
	public abstract void out();
	public int compareTo(Person o)
	{
		return this.getCompareVaue();
	}
}
