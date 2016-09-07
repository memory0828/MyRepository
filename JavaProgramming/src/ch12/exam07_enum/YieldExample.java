package ch12.exam07_enum;

public class YieldExample {
	public static void main(String[] args) throws InterruptedException {
		ThreadA threadA = new ThreadA();	
		threadA.start(); //시작
		
		Thread.sleep(3000);
		threadA.work = Work.PAUAE; //가독성좋아짐
		
		Thread.sleep(3000);
		threadA.work = Work.CONTINUE; //가독성좋아짐

		Thread.sleep(3000); 
		threadA.stop = true;
	}
}