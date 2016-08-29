package ch07.exam06.pack2;
import ch07.exam06.pack1.A;

public class D extends A{
	//Field
	//A a = new A(); 상속과 관련없는 코드 즉 에러남, 별로로 객체생성한거임
	
	//Constru
	D(){
		/* 이것도 상속과 관련없는코드 즉 에러남
		 * 이건 별도로 객체를 생성한거지 상속과 전혀 무관함
		A a = new A();
		a.field = 5;
		a.method();*/
		super(); // A의 생성자를 사용하는것 이건 상속과 관련됨
		field = 5; // A의 field를 사용하는것 이건 상속과 관련됨
		method(); // A의 method를 사용하는것 이건 상속과 관련됨
	}
	
}
