package ch08.exam03;

public class Example {
	public static void main(String[] args) {
		
		//setMute()는 디폴트 접근자의 매소드
		// RemoteControl.setMute(true); 인터페이스는 이렇게 사용못함
		RemoteControl rc = new Television();
		rc.setMute(true);
		
	
	}
}
