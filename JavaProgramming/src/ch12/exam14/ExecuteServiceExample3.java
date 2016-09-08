package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
public class ExecuteServiceExample3 {
	public static void main(String[] args) throws Exception {
		//ThreadPool 생성
		ExecutorService es = Executors.newFixedThreadPool(5);

		//작업 생성
		for(int i=0; i<10; i++){
			int count = i;
			Runnable task = new Runnable() {				
				@Override
				public void run() {
					//스레드풀의 갯수를 출력하기
					ThreadPoolExecutor tpe = (ThreadPoolExecutor)es; //형변환하는 이유는 es에는 갯수출력하는 메소드가 없기때문에
					System.out.println("스레드풀 안의 총 수 : " + tpe.getPoolSize());
					
					System.out.println("실행 중... (" + count + ") : "+ Thread.currentThread().getName());
					
					//execute. submit과의 차이 : 스레드가 도는도중에 예외가 발생하면 어떻게 되는가?
					int value = Integer.parseInt("aa"); //일부로 NumberFormatException 발생시켰음!
				}
			};
			
			//작업 큐에 작업 넣기 - execute. submit과의 차이
			es.submit(task);
			//es.execute(task);
			/*
			 * execute로 이소스가 진행하면 작업도중에 스레드에서 예외가 발생(작업하다에러)되면
			 * 그 스레드를 종료(=run을 종료시켜버림)시켜버리고 처음 지정한 5개안에서 새로운
			 * 스레드를 생성해서 작업을 진행한다.
			 * 이건 곧 스레드를 생성하는 작업이 또 생기는 거기때문에 작업이 더 많아지지..~ㅋ   
			 * 
			 * 반면에 submit로 작업넣기를 하면 예외가 생겨도 에러가 출력되지 않는다. 
			 * (예외처리는했지만 메시지를 출력하지 않았음), 스레드도 종료시키지 않는다.
			 * 책을 좀더 참고해서 이해가 필요하지만 결과적으로 submit이 사용하기 더 좋다. 
			 */
		}
		
		//스레드풀 종류
		es.shutdown();
	}
}
