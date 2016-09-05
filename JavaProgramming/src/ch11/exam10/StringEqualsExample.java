package ch11.exam10;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철"; //리터럴(literal) : 예) "신민철"을 strVar2에 리터럴했다
		
		if(strVar1 == strVar2) { //참조번지가 같은지 확인
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) { //문자열이 같은지 확인
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
	}
}