package ch12.exam01;

import java.awt.Toolkit;
public class BeepPrintExample2 {
	public static void main(String[] args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		//for문1과 2가 같이 실행됨 - 스레드!
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				//for문1
				for(int i=0; i<5; i++){
					t.beep();
					System.out.println(Thread.currentThread().getName()); //현재이 코드를 실행하는 쓰래드을 리턴함.이름을 리턴함
					try { Thread.sleep(500);
					} catch (InterruptedException e) { e.printStackTrace(); }
				}				
			}
		});
		thread.start();
	
		//for문2
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try { Thread.sleep(500);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}


