package ch09.exam08;

public class A {
	//interface B {} 는 아래 처럼 중첩 클래스에 쓸 때 많이 사용한다	
	interface B {}
	class BImple implements B{
	}
	
	//A객체 없어도 C를 사용할수있는 static interface C{	} 
	static interface C{	}
	class CImple implements C{
	}
}
