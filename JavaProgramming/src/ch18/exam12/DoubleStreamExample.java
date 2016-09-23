package ch18.exam12;

import java.io.*;
public class DoubleStreamExample {
	public static void main(String[] args) throws Exception {
		
		//기존방식
		/*
		InputStream is = System.in;
		Reader rd = new InputStreamReader(is);
		//한행 전체를 읽기위해서 작성된 코드
		while(true){
			int value = rd.read();
			if(value == 13) break;
			char data = (char) value;
			System.out.println(data);
		}
		*/
		
		//기존엔 한행을 읽기위해서 이렇게 긴소스를 만들었는데
		//근데...... 간단하게 할수있는 방법이 있다!
		//보조스트림하다 더 달고 readLine()하나 썻을 뿐인데
		InputStream is1 = System.in;
		Reader rd1 = new InputStreamReader(is1);
		BufferedReader br = new BufferedReader(rd1);
		String d2 = br.readLine();
		System.out.println(d2);
	}
}
