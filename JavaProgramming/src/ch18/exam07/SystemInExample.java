package ch18.exam07;

import java.io.*;
import java.util.*;
public class SystemInExample {
	public static void main(String[] args) throws Exception {
		//한개의 키만 읽기
		InputStream is = System.in;
		
		/*
		System.out.println("키 하나만 입력 : ");
		int keyCode = is.read();
		System.out.println(keyCode + ": " + (char)keyCode);
		// 이거 주석처리안하면 아래 소스에서 엔터때문에 입력이 안됨 ㅠ
		*/
			
		//한글과 같은 여러키의 조합을 읽기
		System.out.println("여러 키를 입력 : ");
		byte[] values = new byte[100];
		int byteNum = is.read(values);
		System.out.println(Arrays.toString(values));		
		String data = new String(values, 0, byteNum-2); //복원하기
		System.out.println(data);
	}
}
