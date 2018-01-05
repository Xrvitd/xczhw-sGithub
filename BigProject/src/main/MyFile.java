package main;

import java.io.File;

public class MyFile extends File
{
	public MyFile(String pathname) {
		super(pathname);
	}
	
	public String toString()
	{
		return this.getName();
	}
	
	public MyFile(File f)
	{
		this(f.getPath());
	}
	
	public MyFile[] listFiles()
	{
		File[] f = super.listFiles();
		MyFile[] mf = new MyFile[f.length];
		for(int i = 0;i < f.length;i ++)
			mf[i] = new MyFile(f[i]);
		return mf;
	}
	
	static public String[] getStirng(MyFile[] f)
	{
		String[] s = new String[f.length];
		for(int i = 0;i < f.length;i ++)
			s[i] = f[i].toString();
		return s;
	}
}