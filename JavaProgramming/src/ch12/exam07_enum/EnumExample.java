package ch12.exam07_enum;

import java.util.Calendar;
public class EnumExample {
	public static void main(String[] args) {
		
		//1. 열거타입 선언방법
		//열거타입의 변수 선언 = 열거상수
		//열거타입의 값은 반드시 열거 상수의 값만 대입가능하다
		Week week = Week.THURSDAY;
		
		//2. 열거타입을 쓰게되면 코드 가독성이 좋아진다.
		Calendar now = Calendar.getInstance();
		switch(now.get(Calendar.DAY_OF_WEEK)) {
			case 1: week = Week.SUNDAY; break;
			case 2: week = Week.MONDAY; break;
			case 3: week = Week.TUESDAY; break;
			case 4: week = Week.WEDNEDAY; break;
			case 5: week = Week.FRIDAY; break;
			default : week = Week.SATURDAY; break;
		}
		
		System.out.println(week);
		//제한된 값목록을 표현하고자할떄 enum을 써서 코드를 작성하게 되면 훨씬 코드가 가독성이 좋아진다.
	}
}
