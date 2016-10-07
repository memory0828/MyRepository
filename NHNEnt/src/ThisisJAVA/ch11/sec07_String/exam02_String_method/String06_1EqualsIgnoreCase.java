package ThisisJAVA.ch11.sec07_String.exam02_String_method;

public class String06_1EqualsIgnoreCase {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";		
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2)); //대소문자 구분이 있어야함
		
		System.out.println(str1.equalsIgnoreCase(str2)); //대소문자 구분없이 비교	
	}
}



