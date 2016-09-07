package ch12.exam05;

public class YieldExample {
	public static void main(String[] args) throws InterruptedException {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();	
		threadA.start(); //시작
		threadB.start(); //시작
		
		Thread.sleep(3000); //메인스레드 3초간 일시정지
		threadA.work = false;
		
		Thread.sleep(3000); //메인스레드 3초간 일시정지
		threadA.work = true;

		Thread.sleep(3000); //메인스레드 3초간 일시정지
		threadA.stop = true; //종료=Run메소드를 끝내는상태=터미네이트 상태
		threadB.stop = true; //종료=Run메소드를 끝내는상태=터미네이트 상태
		
	}
}