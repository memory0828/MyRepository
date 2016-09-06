package ch12.exam01;

import java.awt.Toolkit;
public class BeepPrintExample {
	public static void main(String[] args) throws InterruptedException {
		Toolkit t = Toolkit.getDefaultToolkit();
		//for문1이 끝나야 2가 실행됨
		//for문1
		for(int i=0; i<5; i++){
			t.beep();
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);
		}
		//for문2
		for(int i=0; i<5; i++){
			System.out.println("띵");
			Thread.sleep(500);
		}
	}
}

