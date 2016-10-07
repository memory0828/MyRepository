package ThisisJAVA.ch11.sec07_String.exam01_String_constructor;

public class ByteToStringExample {
	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97  };
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4); //바이트배열의 6번째부터 4개의 인덱스를~
		System.out.println(str2);
	}
}
