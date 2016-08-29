package ch06.exam12;

public class StaticMember2 {
	static String field;
	String field2;
	
	static {
		System.out.println("정적 맴버의 static 블럭");
		//static블록 내에서는 static 필드와 메소드를 부를수있다
		field = "자바1"; //접근가능
		method(); //접근가능
		// field2 ="자바2"; 접근안됨 객체가 없기때문에 
	}
	
	static void method(){
		System.out.println("정적 맴버의 메소드");
		// field2 ="자바2"; 접근안됨 객체가 없기때문에(마찬가지)
	}

	void method2(){
		System.out.println("정적 맴버의 메소드");
		// 인스턴스 메소드에서는 인스턴스 필드. 정적 필드 모두 접근가능
		field ="자바1"; 
		field2 ="자바2";
	}
	
	//메인은 프로그램도중에 호출되는게 아니라 JVM에서 자동으로 실행되는거기떄문에
	//클래스맴버(=정적맴버)라고 하지 않고 실행진입 지점이다.
	public static void main(String[] args) {
		//마찬가지로 main도 static 규칙을 따르기때문에 인스턴스맴버는 객체가 있어야 접근 가능하다
	}	
}
