package ch13.exam02;

import java.util.Date;
public class BoxExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		// = Box<String> box1 = new Box<>();
		//다이아몬드연산자 : 타입이 없지만 앞에껄 참조해서 타입이 들어간다. 그래서 생각해도 괜찮단
		box1.set("홍길동");
		String name = box1.get(); //타입 변환할 필요없음 ^^

		//근데 이렇게 구체적인 타입을 지정안해도 되긴한다. 다만 컴파일러가 경고를 준다.
		//뭐 지정안하면 Object로 처리하기 때문에 다양한 타입 처리가 가능한거지
		/*
		Box box2 = new Box();
		box2.set(10);
		*/
		
		//또 제너릭은 클래스나 인터페이스 타입만 사용가능해. 그래서 Integer을 써야하지.. int말고
		Box<Integer> box2 = new Box<Integer>();
		box2.set(10);
		int value = box2.get(); //타입 변환할 필요없음 ^^
		
		Box<Date> box3 = new Box<Date>();
		box3.set(new Date());
		Date now = box3.get(); //타입 변환할 필요없음 ^^
	}
}
