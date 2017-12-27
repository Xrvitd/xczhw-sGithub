package homework_6;

import java.util.ArrayList;

public class Student extends Person
{
	Integer eng,math,pro;
	static final Integer ENG = 6,MATH = 5,PRO = 4;
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
	
	Student(String n, String na, String ag,String eng,String math,String pro) {
		super(n, na, toInteger(ag));
		this.eng = toInteger(eng);
		this.math = toInteger(math);
		this.pro = toInteger(pro);
		return;
	}
	
	static boolean find(String s, ArrayList<Student> per)
	{
		for(Student p : per)
			if(p.num.equals(s))
				return true;
		return false;
	}
	
	int getCompareVaue()
	{
		return (eng + math + pro) / (ENG + MATH + PRO);
	}
	public void out() {
		System.out.println(num + " " + name + " " + age + " "  + eng + " " + math + " " + pro);
		return;
	}
}
