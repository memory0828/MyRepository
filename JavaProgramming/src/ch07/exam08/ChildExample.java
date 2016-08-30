package ch07.exam08;

public class ChildExample {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.method1(); //부모꺼
		c1.method2(); //재정의된 자식꺼
		c1.method3(); //새로 만들어진 자식꺼
	}
}
