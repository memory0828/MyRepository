package ch07.exam13;

public abstract class Phone {
	public String number;
	
	public void ring(){
		System.out.println("벨 울림");
	}
	
	public void sendVoice(){
		System.out.println("목소리 보냄");
	}
	
	public void receiveVoice(){
		System.out.println("목소리 받음");
	}
	
}
