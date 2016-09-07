package ch12.exam10;

public class PrintThread3 extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("실행 중");
			//if( isInterrupted() ) { //interrupted() 상태 비교 - 인스턴스 메소드
			if(Thread.interrupted() ) { //interrupted() 상태 비교 - 정적 메소드
				//false : 외부에서 한번도 호출된적없으면
				//true : 외부에서 한번이라도 호출되었으면
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}