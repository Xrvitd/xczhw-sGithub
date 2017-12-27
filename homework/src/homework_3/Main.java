package homework_3;

import java.util.Scanner;

class Date
{
	static final int M[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	Integer y,m,d,w;
	Date(int Y,int M,int D,int W)
	{
		y = Y;
		m = M;
		d = D;
		w = W;
		return;
	}
	int isRun()
	{
		if(m != 2)
			return 0;
		if(y % 400 == 0)
			return 1;
		if(y % 100 == 0)
			return 0;
		if(y % 4 == 0)
			return 1;
		return 0;
	}
	void add()
	{
		d ++;
		w ++;
		if(w > 7)
			w = 1;
		if(d > M[m] + isRun())
		{
			d = 1;
			m ++;
			if(m > 12)
			{
				m = 1;
				y ++;
			}
		}
		return;
	}
}

class Calendar
{
	int n;
	Date now = new Date(1970, 1, 1, 4);
	int[][][] a = new int[14][10][8];
	Calendar(int n)
	{
		this.n = n;
		return;
	}
	
	void get()
	{
		while(now.y < n)
			now.add();
		while(now.y == n)
		{
			int tot = 0;
			int m = now.m;
			while(now.m == m)
			{
				a[m][tot][now.w] = now.d;
				if(now.w == 7)
					tot ++;
				now.add();
			}
		}
		return;
	}
	
	void out()
	{
		for(int i = 0;i < 4;i ++)
		{
			for(int j = 1;j <= 3;j ++)
			{
				for(int t = 0;t <= 8;t ++)
					System.out.print(" ");
				System.out.print(i * 3 + j + "月");
				for(int t = 0;t <= 10;t ++)
					System.out.print(" ");
			}
			System.out.println();
			
			for(int j = 0;j < 6;j ++)
			{
				for(int k = 1;k <= 3;k ++)
				{
					for(int l = 1;l <= 7;l ++)
					{
						int t = a[k + i * 3][j][l]; 
						if(t != 0)
							System.out.print(t);
						else
							System.out.print(" ");
						if(t < 10)
							System.out.print(" ");
						System.out.print(" ");
					}
					if(k != 3)
						System.out.print("|");
				}
				System.out.println();
			}
			if(i != 3)
				for(int t = 0;t <= 65;t ++)
					System.out.print("-");
			System.out.println();
		}
		return;
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Calendar c = new Calendar(scan.nextInt());
		c.get();
		c.out();
		return;
	}
}
