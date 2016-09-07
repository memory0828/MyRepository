package ch12.exam09;

public class StopFlagExample {
	public static void main(String[] args) {
		PrintThread1 pt1 = new PrintThread1();
		pt1.start();
		try { Thread.sleep(3000); } catch (InterruptedException e) { }
		pt1.setStop(true);
	}
}
