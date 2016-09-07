package ch12.exam13;

public class ThreadGroupExample {
	public static void main(String[] args) {
		//스레드의 이름 보기
		Thread t = Thread.currentThread(); //현재의 쓰래드 정보 획득
		System.out.println("스레드의 이름" + t.getName());
		
		for(int i=0; i<10; i++){
			int count = i;
			Thread t2 = new Thread() { //익명 자식객체
				@Override
				public void run() {
					while(true){
						System.out.println(this.getName() + " 실행중");
						System.out.println("T" + count + " 실행중");
						if( isInterrupted() ) break;
					}
					System.out.println("T" + count + " 종료");
				}
			};
			t2.start();
		}
		
		//스레드가 속한 그룹의 이름 보기
		ThreadGroup tg = t.getThreadGroup(); //이스레드가 소속된 그룹의 정보를 받고 ( main 그룹임 )
		System.out.println("스레드의 그룹이름 : " + tg.getName()); //현재 그룹의 이름을 리턴
		System.out.println("활동중인 쓰레드들 : " + tg.activeCount() ); //활동중인 모든 스레드의 수
		
		//스레드 그룹을 활용하는 방법은
		//이 스레드 그룹안에 여러 명령이 있는데, 그룹으로 묶은 스레드가 있는상태에서
		//이 스레드 그룹에 인터럭트(방해)를 걸어버리면 모든 스레드가 인터럭트가 된다.(그게 데몬이든 아니듯 상관없다)
		tg.interrupt(); //main그룹에 속한 모든거에 인터럽트 걸기
	}
}
