package ch18.exam05;

import java.io.*;
public class CopyExample {
	//카피 프로그램(문자기반 ㅋㅋ)
	public static void main(String[] args) throws Exception {
		Reader rd = new FileReader("data.txt"); //data.txt파일은 이미 존재해야함
		Writer wt = new FileWriter("data2.txt");
	
		char[] values = new char[100];
		int charNum = -1;
		
		while( (charNum = rd.read(values)) != -1)  {
			wt.write(values, 0, charNum); 
		}
		rd.close();
		
		wt.flush();
		wt.close();
	}
}
