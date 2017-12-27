package homework_2;

import java.util.*;

public class Main {
	static boolean isdigit(char c)
	{
		if('0' <= c && c <= '9')
			return true;
		return false;
	}
	
	static ArrayList<Integer> toArray(String s)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer x = 0;
		while(x < s.length())
		{
			Integer ans = 0;
			while(x < s.length() && !isdigit(s.charAt(x)))
				x ++;
			while(x < s.length() && isdigit(s.charAt(x)))
			{
				ans = ans * 10 + s.charAt(x) - '0';
				x ++;
			}
			a.add(ans);
		}
		return a;
	}
	
	static Integer average(ArrayList<Integer> a)
	{
		int ans = 0;
		for(Integer x : a)
			ans += x;
		return ans / a.size();
	}
	
	static void sort(ArrayList<Integer> a)
	{
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(Integer x : a)
			b.add(x);
		for(int i = 0;i < b.size();i ++)
			for(int j = i + 1;j < b.size();j ++)
				if(b.get(i) > b.get(j))
				{
					Integer t = b.get(i);
					b.set(i, b.get(j));
					b.set(j, t);
				}
		for(int i = 0;i < b.size();i ++)
			System.out.print(b.get(i) + (i != b.size() - 1 ? "," : ""));
		System.out.print("#");
		return;
	}
	
	static Integer L(Integer x) {return (x << 1) + 1;}
	static Integer R(Integer x) {return (x << 1) + 2;}
	
	static void hou(ArrayList<Integer> a,Integer x)
	{
		if(x >= a.size())
			return;
		hou(a,L(x));
		hou(a,R(x));
		System.out.print(a.get(x));
		System.out.print(a.get(x) != 1 ? "," : "");
	}
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> a = toArray(scan.nextLine());
		System.out.print(average(a) + "#");
		sort(a);
		hou(a,0);
	}
}
