package ch08.exam01_0;

public class Television implements RemoteControl{

	@Override  //인터페이스에서 설명한 내용대로 제대로 작성이되었는지 컴파일러가 확인하는작업
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}

	@Override
	public void setVolume(int Volume) {
		System.out.println("현재 TV 볼륨:" + Volume);
		
	}

}
