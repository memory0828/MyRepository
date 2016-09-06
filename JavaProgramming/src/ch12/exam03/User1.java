package ch12.exam03;

public class User1 extends Thread{
	private Calculator cal;
	
	@Override
	public void run() {
		cal.setMemory(100);
	}
	
	public void setCal(Calculator cal) {
		this.cal = cal;
		this.setName("User1");
	}
}
