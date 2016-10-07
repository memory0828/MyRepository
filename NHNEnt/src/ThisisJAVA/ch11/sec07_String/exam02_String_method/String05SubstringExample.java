package ThisisJAVA.ch11.sec07_String.exam02_String_method;


public class String05SubstringExample {
	public static void main(String[] args) {	
		//일부분만 가져오기
		String ssn = "880815-1234567 ";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);		
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
	} 
}

