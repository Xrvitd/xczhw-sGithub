package learning;

import java.io.File;
import java.io.IOException;

public class FileTester {
	static void out()
	{
		System.out.println("haha");
	}
	
	public static void main(String[] args)
	{
		File top = new File("/Users/xczhw/FileTester");
		//mkdirs() 如果路径中有部分是不存在的，也会一直创建下去
		//当该文件存在时返回false
		//会调用 getCanonicalFile() 获取规范路径名字符串如果无法获得返回 false
		top.mkdirs();
		
		//第一个参数是父目录，第二个参数是文件名也
		//new File(top,name)就是相当于new File(top.getAbsolutePath() + name)
		
		//createNewFile()当存在时返回false
		//delete() 当文件不存在时返回false
		File file = new File(top, "child");
		try
		{
			file.createNewFile();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		if(file.renameTo(new File("isAtxt.txt")))
			out();
	}
}
