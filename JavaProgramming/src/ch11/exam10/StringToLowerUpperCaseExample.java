package ch11.exam10;

public class StringToLowerUpperCaseExample {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";		
		
		System.out.println(str1 == str2); //false
		System.out.println(str1.equals(str2)); //false
		System.out.println(str1.equals("JAva programming") );
		
		//메소드 체이닝 : 메소드에 . 찍고 또 . 찍고 ㅋㅋㅋ
		System.out.println(str1.toLowerCase().equals("Java pRogramming".toLowerCase())  );
		System.out.println(str1.toUpperCase().equals("Java pRogramming".toUpperCase())  );
		
		//trim
		String targetStr = "           Java Programming";
		System.out.println(str1 == targetStr);
		System.out.println(str1.toLowerCase().equals(targetStr.toLowerCase().trim() ) );
		
		
		String lowerStr1 = str1.toLowerCase(); //대문자있는걸 소문자로 
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2)); //true
		System.out.println(str1.equalsIgnoreCase(str2)); //이건 모지??????
	}
}
