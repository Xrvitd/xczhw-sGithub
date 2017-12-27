package homework_8;

import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Mover move = new Mover(n);
		move.dfs(n, 0, 1, 2);
		return;
	}
}
