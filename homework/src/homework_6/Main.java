package homework_6;

import java.util.*;
import java.io.*;

class personSorter implements Comparator<Person>
{

	public int compare(Person p1, Person p2) {
		if(p1.age == p2.age)
			return p1.num.compareTo(p2.num);
		return p1.age - p2.age;
	}
	
}

public class Main {
	public static void main(String[] args)
	{
		ArrayList<Student> stu = new ArrayList<Student>();
		ArrayList<Staff> sta = new ArrayList<Staff>();
		ArrayList<Person> per = new ArrayList<Person>();
		try
		{
			Scanner scan = new Scanner(new FileInputStream(new File("T6.in")));
			while(scan.hasNext())
			{
				String in = scan.nextLine();
				String[] s = in.split(" ");
				if(s.length == 6)
				{
					if(!Student.find(s[0], stu))
						stu.add(new Student(s[0],s[1],s[2],s[3],s[4],s[5]));
				}
				else
				{
					if(!Staff.find(s[0], sta));
						sta.add(new Staff(s[0],s[1],s[2],s[3]));
				}
			}
			per.addAll(stu);
			per.addAll(sta);
			personSorter ps = new personSorter();
			Collections.sort(per, ps);
			for(Person p : per)
				p.out();
			
			Collections.sort(stu);
			for(Student student : stu)
				student.out();
			Collections.sort(sta);
			for(Staff staff : sta)
				staff.out();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
