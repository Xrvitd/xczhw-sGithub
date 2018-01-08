package main;

import java.io.File;
import java.util.ArrayList;

public class MyFile extends File
{
	public static ArrayList<Tag> allTag = new ArrayList <Tag>();
	
	public static void newTag(Tag t)
	{
		for(Tag i : allTag)
			if(i.equals(t))
				return;
		allTag.add(t);
	}
	
	public static void removeTag(Tag t)
	{
		allTag.remove(t);
	}
	
	public static ArrayList <Tag> getAllTag()
	{
		return allTag;
	}
	
	ArrayList <Tag> tags = new ArrayList<Tag>();
	
	public void addTag(Tag t)
	{
		for(Tag i : tags)
			if(i.equals(t))
				return;
		tags.add(t);
	}
	
	public void delTag(Tag t)
	{
		tags.remove(t);
	}
	
	public ArrayList<Tag> getTag()
	{
		return tags;
	}
	
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