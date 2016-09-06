package ch12.exam02;

public class ThreadPriorityExample {
	public static void main(String[] args) {
		Thread thread = null;
		for(int i=1; i<=100; i++){
			thread = new ThreadC(i);
			if( i != 100 ){
				thread.setPriority(Thread.MIN_PRIORITY);
			}else{
				//100번쨰만 실행됨. ThreadC-100이 좀더 빨리끝나는 상황이 많아짐
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
