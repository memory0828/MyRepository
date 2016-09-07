package ch12.exam08;

public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObject sObject = new WorkObject();
		ThreadA tA = new ThreadA(sObject);
		ThreadB tB = new ThreadB(sObject);
		tA.start(); //실행대기
		tB.start(); //실행대기
	}
}
