package ch12.exam08;

public class WorkObject {
	//이코드에서는 ThreadA가 methodA()를 실행하는동안은 ThreadB는 methodA()와 methodB()를 실행할수없다)
	public synchronized void methodA(){
		System.out.println("ThreadA의 methodA() 작업실행");
		//notify();와  wait();는 object안에 있는 메소드라 바로 사용가능
		notify(); 
		try { wait(); } catch (InterruptedException e) { }
	}
	public synchronized void methodB(){
		System.out.println("ThreadB의 methodB() 작업실행");
		//notify();와  wait();는 object안에 있는 메소드라 바로 사용가능
		notify();
		try { wait(); } catch (InterruptedException e) { }		
	}
}
