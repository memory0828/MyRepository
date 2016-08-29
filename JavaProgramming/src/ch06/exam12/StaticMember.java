package ch06.exam12;

public class StaticMember {
	static String field;
	
	static {
		System.out.println("정적 맴버의 static 블럭");
		//static블록 내에서는 static 필드와 메소드를 부를수있다
		method();
		
	}
	
	static void method(){
		System.out.println("정적 맴버의 메소드");
	}
	
}
