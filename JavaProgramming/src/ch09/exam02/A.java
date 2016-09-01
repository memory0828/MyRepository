package ch09.exam02;

public class A {
	//Field
	//Costructor
	//Method
	public void method1(){
		//이 로컬클래스는 이 method1 메소드의 시작부터 끝까지만 사용가능
		//즉 외부에서 접근할수없고 이 method1 메소드에서만 사용가능하다
		//하지만 엄밀히말해서 클래스이기때문에 안에서 필드,생성자,메소드 모두 사용가능
		class B { 
			/*class B앞에 접근제한자가 생략된게 아닌 애초에 method1()에서만 사용가능함으로 접근제한자가 필요없다
			  그래서 로컬클래스라고 하지!*/
			//Field : 클래스니깐! 사용가능
			//Costructor : 클래스니깐! 사용가능
			//Method : 클래스니깐! 사용가능
		}
		B b = new B(); //이렇게 method1 메소드 안에서 선언해서 사용하는거다 ㅋ
	}
}
