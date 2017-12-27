package homework_1;

import java.util.*;

public class Main {
	static void toEJZ(int x)
	{
		int i = 30;
		while(((x >> i) & 1) == 0)
			i --;
		while(i >= 0)
			System.out.print(x >> (i --) & 1);
		return;
	}
	
	static void ZYS(int x)
	{
		for(int i = 2;x != 1;i ++)
			while(x % i == 0)
			{
				System.out.print(i);
				x /= i;
				System.out.print(x == 1 ? "\n" : ",");
			}
		return;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		toEJZ(n);
		System.out.print("#");
		ZYS(n);
		return;
	}
}
