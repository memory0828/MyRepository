package ch18.exam02;

import java.io.FileOutputStream;
import java.io.OutputStream;
public class OutputStreamExample {
	public static void main(String[] args) throws Exception {
		//주요메소드1. write(int b) 메소드 방법
		OutputStream os = new FileOutputStream("test.txt");
		String data = "abcdefghij";
		byte[] values = data.getBytes();
		for(int i=0; i< values.length; i++) {
			os.write(values[i]);
		}
		os.flush();
		os.close();
		
		//주요메소드2. write(byte[] b) 메소드 : 이 방식을 더 단순하니 많이 씁시다
		os = new FileOutputStream("test2.txt");
		data = "abcdefghij";
		values = data.getBytes();
		os.write(values);
		os.flush();
		os.close();		
	}
}
