package ch12.exam01;

import java.awt.Toolkit;
public class BeepPrintExample4 {
	public static void main(String[] args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		//for문1과 2가 같이 실행됨 - 스레드!
		Thread thread = new SoundThread();
		thread.start(); //<- start()을 실행하면 run()이 실행된다.
		
		//for문2
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try { Thread.sleep(500);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}


