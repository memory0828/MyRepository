package ch09.exam12;

public class AnonymousTest {
	//필드
	//private RemoteControl rc = new RemoteControl(); 이건 안됨
	private RemoteControl rc = new RemoteControl(){}; //이건됨
	
	//생성자
	AnonymousTest() {
		RemoteControl rc = new RemoteControl() { };
	}
	
	//메소드
	public void method1(RemoteControl rc) {
	}
	public void method2() {
		method1( new RemoteControl() {} );
	}	
	
}
