package homework_4;

import java.util.*;
import java.io.File;

public class Main {
	static void dfs(File f,String s)
	{
		File[] fs = f.listFiles();
		if(f.isFile())
			System.out.println(s + "<f>" + f.getName());
		else
			System.out.println(s + "<d>" + f.getName());
		if(fs == null)
			return;
		for(File sf : fs)
			dfs(sf,s + " ");
		return;
	}
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		File f = new File(scan.nextLine());
		dfs(f,"");
	}
}
