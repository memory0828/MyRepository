package ch09.exam10;

public class Example {
	public static void main(String[] args) {
		Parent p1 = new Parent(); //이건 Parent 객체를 만든거고
		
		Parent p2 = new Parent() {};
		//Parent는 클래스임으로 이 Parent을 생성하고 그것을 상속받은 자식 객체를 만든다
		//이건 마치 class XXX extends Parent {
		//}의
		// 뜻과 같다. 
		// new Parent() {       }; 이곳은 자식클래스를 만들지만 자식클래스의 이름은 없고
		//그걸 p2로 만들어낸거다. 이건 상속받은거고
		
		RemoteControl p3 = new RemoteControl() {};
		//이 인터페이스를 구현한 구현 클래스를 이렇게 만들고 그것을 객체로 만들어서 여기에 번지를 넣는다
		//이건 마치 class XXX implements RemoteControl {
		//}의
		// 뜻과 같다. 
		// new RemoteControl() {       }; 이곳은 인터페이스를 구현한 객체를 만들지만 이름은 없고
		//그걸 p3로 만들어낸거다. 이건 인터페이스를 구현한 객체
	}
}
