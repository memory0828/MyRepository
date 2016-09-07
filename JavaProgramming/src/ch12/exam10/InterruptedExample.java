package ch12.exam10;

public class InterruptedExample {
	public static void main(String[] args) {
		PrintThread2 pt2 = new PrintThread2();
		pt2.start();
		try { Thread.sleep(3000); } catch (InterruptedException e) { }
		pt2.interrupt();
	}
}
