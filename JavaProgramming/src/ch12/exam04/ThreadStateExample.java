package ch12.exam04;

public class ThreadStateExample {
	public static void main(String[] args) {
		//new TargetThread()는 new StatePrintThread생성자의 매개값으로 넘김거임
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());  
		statePrintThread.start();
	}
}