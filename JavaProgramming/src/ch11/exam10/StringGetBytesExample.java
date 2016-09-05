package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "안녕하세요";
		
		//String -> byte[]
		byte[] bytes1 = str.getBytes(); //문자열을 바이트배열로 만들고 싶을 때, 그 배열값 리턴, 편집기의 인코딩설정값을 따라감 
		System.out.println("bytes1.length: " + bytes1.length);
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println("bytes2.length: " + bytes2.length);		
		byte[] bytes3 = str.getBytes("UTF-8");
		System.out.println("bytes3.length: " + bytes3.length);

		//byte[] -> String
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
		String str2 = new String(bytes2, "EUC-KR");
		System.out.println("bytes2->String: " + str2);
		String str3 = new String(bytes3, "UTF-8");
		System.out.println("bytes3->String: " + str3);
	}
}
