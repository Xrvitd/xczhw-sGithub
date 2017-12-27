package homework_5;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	static ArrayList<Student> stu;
	static ArrayList<Class> cla;
	
	public static void main(String[] args)
	{
		stu = new ArrayList<Student>();
		cla = new ArrayList<Class>();
		try
		{
			for(int i = 1;i <= 3;i ++)
			{
				Scanner s = new Scanner(new FileInputStream("S" + i + ".txt"));
				Student.scan(s,stu);
				
				Scanner c = new Scanner(new FileInputStream("C" + i + ".txt"));
				Class.scan(c,cla);
				
				Scanner a = new Scanner(new FileInputStream("A" + i + ".txt"));
				while(a.hasNext())
				{
					String stuNum = a.next();
					String claNum = a.next();
					Integer fs = a.nextInt();
					//a.nextLine();
					
					Student st = Student.findStu(stuNum, stu);
					Class cl = Class.findCla(claNum, cla);
					st.add(cl, fs);
				}
				for(Student st : stu)
					st.getGPA();
				Collections.sort(stu);
				for(Student st : stu)
					st.out();
			}
		}catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
}
