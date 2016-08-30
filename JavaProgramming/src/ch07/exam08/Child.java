package ch07.exam08;

public class Child extends Parent{
	@Override
	public void method2() {
		System.out.println("자식-재정의된 method2");
	}
	
	public void method3() {
		System.out.println("자식-새로만들어진-method3");
	}	
}
