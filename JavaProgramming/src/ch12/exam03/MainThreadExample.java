package ch12.exam03;

public class MainThreadExample {
	public static void main(String[] args) {
		//공유 객체 생성
		Calculator cal = new Calculator();
		
		//쓰레드 객체 생성
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		//공유객체를 각 스레드에게 주입
		user1.setCal(cal);
		user2.setCal(cal);
		user1.start(); //50 ??? 100이 나와야하는데!! 이래서 공유객체사용할떄 주의해야함. 그럼 이걸 해결할 방법은?
		user2.start(); //50
	}
}

