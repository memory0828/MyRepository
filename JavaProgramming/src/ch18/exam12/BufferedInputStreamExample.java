package ch18.exam12;

import java.io.*;
public class BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		//버퍼 안붙이고 사용했을 때 로딩속도
		FileInputStream fis = new FileInputStream("Desert.jpg");
		start = System.currentTimeMillis();
		while(fis.read() != -1){ }
		end =	System.currentTimeMillis(); 
		System.out.println(end - start);

		//버퍼를 붙이는 보조스트림을 써서 사용했을 떄 로딩속도!
		FileInputStream fis2 = new FileInputStream("Desert.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read() != -1){ }
		end =	System.currentTimeMillis(); 
		System.out.println(end - start);		// 우오 매우 빨라짐
	}
}
