package ch18.exam07;

import java.io.*;
import java.util.*;
public class SystemOutExample {
	public static void main(String[] args) throws Exception {
		System.out.println("콘솔에 출력합니다.");
		OutputStream os = System.out;
		String data = "콘솔에 출력합니다.";
		byte[] values = data.getBytes();
		os.write(values);
		os.flush();
		os.close();
		
		System.err.println("콘솔에 출력합니다."); //다른 스레드로 출력됨(그래서 실행할때마다 이상하게 찍힘)
	}
}
