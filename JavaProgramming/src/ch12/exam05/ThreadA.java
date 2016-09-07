package ch12.exam05;

public class ThreadA extends Thread {	
	public boolean stop = false; 
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadA 작업 내용");
			} else {
				Thread.yield(); //다른 스레드에게 실행양보
			}
		}
		System.out.println("ThreadA 종료");
	}
}

