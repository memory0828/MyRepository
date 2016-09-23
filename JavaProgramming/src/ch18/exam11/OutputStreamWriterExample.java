package ch18.exam11;

import java.io.*;
public class OutputStreamWriterExample {
	public static void main(String[] args) throws Exception {	
		OutputStream os = System.out;
		String d1 = "가";
		
		//기존방식
		/*
		byte[] values = d1.getBytes();
		for(int i=0; i<values.length; i++){
			os.write(values[i]);
		}
		os.flush();
		*/
		
		//보조 스트림 사용 
		Writer wr = new OutputStreamWriter(os);
		wr.write(d1);
		wr.flush();
		//간단한 소스로 똑같은 결과 만들어낼수있음
	}
}
