package ch06.exam14;

public class Calculator2 {
	//인스턴스 필드
	final int field2=5;
	//정적 필드	
	static final int field4=4;
	
	//Constructor
	Calculator2(){
		//인스턴스 필드 상수가 만들어지자마자 초기화되어있기때문에
		//여기서 초기화 불가능
		
	}
	
	static {
		//정적 필드 상수가 만들어지자마자 초기화되어있기때문에
		//여기서 초기화 불가능(마찬가지)
	}
}
