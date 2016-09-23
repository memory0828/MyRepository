package ch18.exam09;

import java.io.File;
import java.util.Date;
public class FileExample2 {
	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/aaa/bbb/ccc.txt");
		dir.getParentFile().mkdirs();
		dir.createNewFile();
		
		System.out.println(new Date(dir.lastModified()));
	}
}
