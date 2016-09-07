package ch12.exam07_enum;

public class ThreadA extends Thread {	
	public boolean stop = false; 
	public Work work = Work.CONTINUE;
	
	@Override
	public void run() {
		while(!stop) {
			if(work == work.CONTINUE) {
				System.out.println("ThreadA 작업 내용");
			} else if(work == work.PAUAE) {
				Thread.yield(); //다른 스레드에게 실행양보
			}
		}
		System.out.println("ThreadA 종료");
	}
}

