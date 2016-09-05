package ch11.exam10;

public class StringReplaceExample {
	public static void main(String[] args) {
		/*
		 * replace(char oldChar, char newChar)	문자하나를 문자로 
		 * replace(CharSequence target, CharSequence replacement)
		*/
		
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
	}
}

