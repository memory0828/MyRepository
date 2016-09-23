package ch18.exam01;

import java.io.*;
import java.util.Arrays;
public class InputStreamEx2 {
	public static void main(String[] args) throws Exception { 
		String path = InputStreamEx2.class.getResource("data.txt").getPath();
		System.out.println(path);
		
		InputStream is = new FileInputStream(path); //파일로 부터 바이트단위로 읽겠다
		int cnt = 0;
		byte[] values = new byte[3];
		while(true){
			int byteNum = is.read(values);
			if( byteNum == -1) break;
			cnt++;
			System.out.println(byteNum + ": " + Arrays.toString(values));
		}
		System.out.println("읽어들인 횟수" + cnt);
		is.close();
	}
}
