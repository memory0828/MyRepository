package ch18.exam10;

import java.io.*;
public class Example {
	public static void main(String[] args) throws Exception {
		//파일 복사프로그램2 근데 알다싶이 복사프로그램은 이 문자방식이 아니라 
		//FileInputStream / FileOutputStream 사용해서 만들어야 한다(왜? 뭘 복사할지 모르기때문)
		FileReader fr = new FileReader("pic.gif");
		FileWriter fw = new FileWriter("pic2.gif");
		
		char[] values = new char[1024];
		int byteNum;
		while( (byteNum = fr.read(values)) != -1  ){
			fw.write(values, 0, byteNum);
		}
		fr.close();
		
		fw.flush();
		fw.close();
	}
}