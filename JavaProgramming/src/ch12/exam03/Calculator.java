package ch12.exam03;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//방법1 synchronized 메소드
	public synchronized void setMemory(int memory) { //공유객체문제를 해결하기위해 synchronized 메소드로 지정함
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { }
		System.out.println(Thread.currentThread().getName() + ":" + this.memory );
	}
	
	//방법2 synchronized 블록 : 근데 이것보다는 메소드에 붙이는 방식을 더 많이사용함
	/*
	public void setMemory(int memory) {
		synchronized(this){ //공유객체문제를 해결하기 위해 synchronized 블록지정함
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { }
			System.out.println(Thread.currentThread().getName() + ":" + this.memory );
		}
	}
	*/	
}
