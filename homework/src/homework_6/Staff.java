package homework_6;

import java.util.ArrayList;

public class Staff extends Person
{
	int sal;
	static boolean isdigit(char c)
	{
		return '0' <= c && c <= '9';
	}
	static Integer toInteger(String s)
	{
		Integer ans = 0;
		for(int i = 0;i < s.length();i ++)
		{
			if(!isdigit(s.charAt(i)))
				continue;
			ans *= 10;
			ans += s.charAt(i) - '0';
		}
		return ans;
	}
	
	static boolean find(String s, ArrayList<Staff> per)
	{
		for(Staff p : per)
			if(p.num.equals(s))
				return true;
		return false;
	}
	
	Staff(String n, String na, String ag, String salarys)
	{
		super(n, na, toInteger(ag));
		sal = toInteger(salarys).intValue();
	}
	
	int getCompareVaue()
	{
		return sal;
	}
	
	public void out() {
		System.out.println(num + " " + name + " " + age + " " + sal);
	}
}
