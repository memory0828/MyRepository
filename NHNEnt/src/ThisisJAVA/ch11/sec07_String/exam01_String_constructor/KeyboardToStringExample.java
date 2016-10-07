package ThisisJAVA.ch11.sec07_String.exam01_String_constructor;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes);

		String str = new String(bytes, 0, readByteNo-2); //CL lp의 -2를 뺌
		System.out.println(str);
	}
}
