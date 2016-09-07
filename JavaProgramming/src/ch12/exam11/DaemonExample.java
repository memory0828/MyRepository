package ch12.exam11;

public class DaemonExample {
	public static void main(String[] args) {
		AutoSaveThread ast = new AutoSaveThread();
		ast.setDaemon(true); //주 스레드의 데몬스레드 정의, 여기서 주스레드는 main스레드
		ast.start();
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		System.out.println("메인 스레드 종료");
	}
}
