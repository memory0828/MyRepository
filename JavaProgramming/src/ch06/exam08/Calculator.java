package ch06.exam08;

public class Calculator {
	void powerOn(){
		System.out.println("전원 켜짐");
	}
	
	void PowerOff(){
		System.out.println("전원 꺼짐");
	}
	
	int plus(int x, int y){
		return x + y;
	}
	
	double dec(int x, int y){
		return (double)x / y;
	}
}
