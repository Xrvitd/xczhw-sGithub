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
		//mkdirs() 濡傛灉璺緞涓湁閮ㄥ垎鏄笉瀛樺湪鐨勶紝涔熶細涓�鐩村垱寤轰笅鍘�
		//褰撹鏂囦欢瀛樺湪鏃惰繑鍥瀎alse....
		//浼氳皟鐢� getCanonicalFile() 鑾峰彇瑙勮寖璺緞鍚嶅瓧绗︿覆濡傛灉鏃犳硶鑾峰緱杩斿洖 false
		top.mkdirs();
		
		//绗竴涓弬鏁版槸鐖剁洰褰曪紝绗簩涓弬鏁版槸鏂囦欢鍚嶄篃
		//new File(top,name)灏辨槸鐩稿綋浜巒ew File(top.getAbsolutePath() + name)
		
		//createNewFile()褰撳瓨鍦ㄦ椂杩斿洖false
		//delete() 褰撴枃浠朵笉瀛樺湪鏃惰繑鍥瀎alse
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
