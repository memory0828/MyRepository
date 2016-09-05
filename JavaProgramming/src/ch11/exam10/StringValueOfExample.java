package ch11.exam10;

public class StringValueOfExample {
	public static void main(String[] args) {
		//숫자나 논리값을 문자로
		String str1 = "" + 10; //숫자10이 아님, 문자 ""와 합처져서 문자처리됨
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		//문자를 숫자로
		System.out.println(Integer.parseInt(str1));
	}
}
