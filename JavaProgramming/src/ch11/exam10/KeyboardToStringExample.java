package ch11.exam10;

import java.io.IOException;
public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes); //읽은 바이트의 수 리턴해서 readByteNo에 저장

		String str = new String(bytes, 0, readByteNo-2); //뒤의 엔터 2바이트를 빼고 문자만으로 str에 저장함
		System.out.println(str);
	}
}
