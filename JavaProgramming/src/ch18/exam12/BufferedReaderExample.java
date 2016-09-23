package ch18.exam12;

import java.io.*;
public class BufferedReaderExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("NAVER.html");
		BufferedReader br = new BufferedReader(fr);
		
		//성능향상을 위해 보조스트림을 많이쓰지만 readLine의 편리성떄문에 사용하는경우도 많당!
		int cnt = 0;
		while(true){
			String line = br.readLine();
			//.readLine();은 행단위로 계속 읽다가 더이상 리턴할게 없으면 null을 리턴함
			if(line == null) break;
			System.out.println( (++cnt) + ":" + line );
		}
	}
}
