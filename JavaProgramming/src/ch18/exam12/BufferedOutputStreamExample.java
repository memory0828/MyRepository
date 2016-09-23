package ch18.exam12;


import java.io.*;
public class BufferedOutputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		//버퍼 안붙이고 사용했을 때 로딩속도
		FileInputStream fis = new FileInputStream("Desert.jpg");
		FileOutputStream fos = new FileOutputStream("Desert2.jpg");
	
		int value;
		start = System.currentTimeMillis();
		while( (value = fis.read() ) != -1){
			fos.write(value);
		}
		end =	System.currentTimeMillis(); 
		System.out.println(end - start);
		fos.flush();
		fos.close();
		fis.close();

		//버퍼 붙이고!
		FileInputStream fis2 = new FileInputStream("Desert.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		FileOutputStream fos2 = new FileOutputStream("Desert2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		int value2;
		start = System.currentTimeMillis();
		while( (value2 = bis.read() ) != -1){ 
			bos.write(value2);
		}
		end =	System.currentTimeMillis(); 
		System.out.println("버퍼 붙이고 속도 : " + (end - start) );
		fos2.flush();
		fos2.close();
		fis2.close();
	}
}
