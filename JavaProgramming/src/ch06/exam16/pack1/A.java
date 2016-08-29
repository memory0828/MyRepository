package ch06.exam16.pack1;

public class A {
	private int field1;	//개인적인것
	int field2; //같은패키지에서 사용할수있는것(가족이 사용할수있는것) 즉 위에 pack1 패키지안에서만 사용할수있음
	public int field3; //모두 사용할수있는것

	//생성자도 마찬가지
	private A(){}
	A(int field1){}
	public A(String field1){}
	
	//매소드도 마찬가지
	private void method1(){}
	void method2(){}
	public void method3(){}

}
