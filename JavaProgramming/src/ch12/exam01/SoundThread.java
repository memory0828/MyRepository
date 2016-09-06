package ch12.exam01;

import java.awt.Toolkit;
public class SoundThread extends Thread{
	//Field
	Toolkit t = Toolkit.getDefaultToolkit();
	//Constructor
	public SoundThread(){
		this.setName("사운드 스레드"); //스레드 이름 지정하기
	}
	//Method
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			t.beep();
			System.out.println(Thread.currentThread().getName()); //현재이 코드를 실행하는 쓰래드을 리턴함.이름을 리턴함					
			try { Thread.sleep(500);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}	
	}
}
