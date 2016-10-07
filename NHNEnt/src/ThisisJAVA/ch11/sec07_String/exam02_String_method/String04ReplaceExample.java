package ThisisJAVA.ch11.sec07_String.exam02_String_method;

public class String04ReplaceExample {
	public static void main(String[] args) {
		//일부분 바꾸기
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
	}
}

