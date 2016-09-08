package ch13.exam08;

public class TextendsExample {
	public void method1(C1<Integer> arg) {}
	public void method2(C1<? extends Number> arg) {} //C1이 존재하는 상태
	public C1<? extends Number> method3() { return null; } //C1이 존재한상태
	//public C1<T extends Number> method4() { return null; } //안되~ 이미있는데 만드는거니깐	
}

class C1<T> {} //선언
class C2<T extends Number> {} //선언
class C3{ 
	public <T>void method(T t) {} //새로 선언
	public <T extends Number> void method(T t) {} //새로 선언
	//public <? extends Number> void method(T t) {} 이건안됨 기존의 제너릭타입이 안왔으니깐
}
