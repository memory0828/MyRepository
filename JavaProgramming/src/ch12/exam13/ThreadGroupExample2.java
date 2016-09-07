package ch12.exam13;

public class ThreadGroupExample2 {
	public static void main(String[] args) {
		/*
		Thread thread;
		thread = new Thread("t1") {   };
		*/
		/* 바로 위의 의미를 풀어쓴게 아래임
		 * 익명객체를 생성하는거긴한데 부모생성자를 호출하면서 생성하는거 
		class XXX extends Thread {
			public XXX(){
				super("t1");
			}
		}
		new XXX();
		*/
		Thread thread;
		thread = new Thread("t1") {
			@Override
			public void run() {
				while(true){
					System.out.println(this.getName() + " 실행중");
					if( isInterrupted() ) break;
				}
				System.out.println(this.getName() + " 종료");
			}
		};
		thread.start();
		
		thread = new Thread("t2") {
			@Override
			public void run() {
				while(true){
					System.out.println(this.getName() + " 실행중");
					if( isInterrupted() ) break;
				}
				System.out.println(this.getName() + " 종료");
			}
		};
		thread.start();

		ThreadGroup sub = new ThreadGroup("sub"); //main 그룹->sub그룹 만들기
		thread = new Thread(sub, "t3") { //sub 밑에 들어가는 스레드 만들기
			@Override
			public void run() {
				while(true){
					System.out.println(this.getName() + " 실행중");
					if( isInterrupted() ) break;
				}
				System.out.println(this.getName() + " 종료");
			}
		};
		thread.start();		

		thread = new Thread(sub, "t4") { //sub 밑에 들어가는 스레드 만들기
			@Override
			public void run() {
				while(true){
					System.out.println(this.getName() + " 실행중");
					if( isInterrupted() ) break;
				}
				System.out.println(this.getName() + " 종료");
			}
		};
		thread.start();
		
		//3초뒤에 그룹에 인터럽트 걸리기
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		
		//sub.interrupt(); //sub그룹에 속한 모든 스레드에 인터럽트 걸기
		Thread.currentThread().getThreadGroup().interrupt(); //메소드 체이닝 - main그룹에 속한 모든 스레드에 인터럽트 걸기
	}
}
