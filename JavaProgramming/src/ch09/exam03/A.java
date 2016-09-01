package ch09.exam03;

public class A {
	public void method1(){
		int value = 1; //final 이 생략되있는 상태, 즉 final특성을 가지고 있다
		class B { 
			//Field
			//생성자
			//메소드
			public void method2(){
				int result = value + 1; 
				System.out.println(result);
			}
		}
		B b = new B(); 
		b.method2(); //2나옴!
	}
}
