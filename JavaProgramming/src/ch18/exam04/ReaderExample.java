package ch18.exam04;
import java.io.*;
public class ReaderExample {
	public static void main(String[] args) throws Exception {
		//주요메소드1. read() 메소드
		FileReader fr = new FileReader("data.txt");
		String data = "";
		int value = -1;
		while (  (value= fr.read()) != -1 ) {
			char ch = (char)value;
			data += ch;
		}
		fr.close();
		System.out.println(data);
		
		//주요메소드2. read(char[] cbuf) 메소드 와
		//주요메소드3. read(char[] cbuf, int off, int len) 메소드
		fr = new FileReader("data.txt");
		data = "";
		char[] values = new char[3];
		int charNum = -1;
		while (  (charNum = fr.read(values)) != -1 ) {
			//data += new String(values); //이렇게하면 마지막 읽어들이는게 2개뿐이면 하나는 배열에 남아있음에 결과값이이상함(알지?)
			//그래서 이렇게 해야함
			data += new String(values, 0, charNum);			
		}
		fr.close();
		System.out.println(data);		
	}
}
