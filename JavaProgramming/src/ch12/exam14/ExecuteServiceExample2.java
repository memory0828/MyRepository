package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample2 {
	public static void main(String[] args) throws Exception {
		//ThreadPool 생성
		ExecutorService es = Executors.newFixedThreadPool(50);

		//작업 생성
		for(int i=0; i<1000; i++){
			int count = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					for(int i=0; i<10; i++){
						System.out.println("실행 중... (" + count + ")  " + Thread.currentThread().getName());
					}
				}
			};
			
			//작업 큐에 작업 넣기
			es.submit(task);
		}
		
		//스레드풀 종류
		es.shutdown();
	}
}
