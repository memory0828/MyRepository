package ch12.exam04;

public class TargetThread extends Thread {	
	public void run() {
		for(long i=0; i<1000000000; i++) {} //RUNNABLE 상태
		
		try {
			//1.5초간 일시 정지
			Thread.sleep(1500); //TIMED_WAITING 상태임
		} catch(Exception e) {}
		
		for(long i=0; i<1000000000; i++) {}
	}
}
