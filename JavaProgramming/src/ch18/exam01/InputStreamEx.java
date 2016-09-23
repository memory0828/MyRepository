package ch18.exam01;

import java.io.*;
public class InputStreamEx {
	public static void main(String[] args) throws Exception { 
		String path = InputStreamEx.class.getResource("data.txt").getPath();
		System.out.println(path);
		
		InputStream is = new FileInputStream(path); //파일로 부터 바이트단위로 읽겠다
		int cnt = 0;
		while(true){
			int v = is.read();
			if(v == -1) break;
			cnt++;
			System.out.println(v);
		}
		System.out.println("읽어들인 횟수" + cnt);
		is.close();
	}
}
