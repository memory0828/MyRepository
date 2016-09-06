package ch12.exam04;

public class StatePrintThread extends Thread {	
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	public void run() {
		while(true) {
			//Thread.State state 클래스안의 클래스. 중첩클래스~의 객체 선언 즉 스레드클래스안의 중첩 클래스
			//targetThread.getState(); 스레드의 현재 상태를 반환하는 메소드
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상태: " + state);
			if(state == Thread.State.NEW) { //NEW 상태
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) { //스레드의 상태가 터미네이티드가 되었을때 while문 종료
				break;
			}
			try {
				//0.5초간 일시 정지
				Thread.sleep(500);
			} catch(Exception e) {}
		}
	}
}

