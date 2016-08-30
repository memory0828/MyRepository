package ch07.exam13;

public class Example {

	public static void main(String[] args) {
		
		SmartPhone p1 = new SmartPhone();
		p1.number = "010-1234-1234";
		p1.ring();
		p1.sendVoice();
		p1.receiveVoice();
		p1.internet();
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		HomePhone p2 = new HomePhone();
		p2.number = "02-4321-4321";
		p2.ring();
		p2.sendVoice();
		p2.receiveVoice();
		p2.address = "서울 어딘가";
		
	}

}
