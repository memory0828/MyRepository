package ch08.exam01_0;

public class Example {

	public static void main(String[] args) {
		int max = RemoteControl.MAX_VOLUME;
		int min = RemoteControl.MIN_VOLUME;
		
		//추상메소드 호출
		//추상메소드라 현재 객체가없어서 실행이안된다.
		//RemoteControl.turnOn();			
		//RemoteControl.turnOff();		
		//RemoteControl.setVolume(RemoteControl.MAX_VOLUME);
		
		//디폴트 메소드 호출
		//디폴트메소드는 현재 객체가없어서 실행이안된다.
		//RemoteControl.setMute(true);		

		
		RemoteControl.changeBattery();
		
		//----------------------------------------------
		Television tv = new Television();
		tv.turnOn();
		
		RemoteControl rc = tv;
		rc.turnOn();

	}

}
