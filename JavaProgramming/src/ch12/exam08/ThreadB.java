package ch12.exam08;

public class ThreadB extends Thread{
	public WorkObject wO;
	
	//주입(Injection) : 외부에서 객체를 받아서 내부에 저장한다
	public ThreadB(WorkObject wO){
		//생성자주입(Constructor Injection)
		this.wO = wO; //주입 
	}
	public void setwO(WorkObject wO) {
		//세터 주입(Setter Injection)
		this.wO = wO; //주입
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			wO.methodB();
		}
	}
}
