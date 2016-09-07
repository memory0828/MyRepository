package ch12.exam08_ex2;

public class WaitNotifyExample {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);
		
		consumerThread.start();
		producerThread.start();

	}
}