package ch06.exam15;
import ch06.exam15.pack1.*;
import ch06.exam15.pack2.*;
//pack1에도 C라는 클래스가 있고 pack1에도 C라는 클래스가있을떄

public class Example {
	public static void main(String[] args) {
		//이상태에서는 클래스를 찾을수없음으로 에러남
		A a = new A();
		B b = new B();
		//C c = new C(); pack1, pack2에 모두 C가 있어서 에러남(import에서 모두 .*가 되있기떄문에)
		//
		/*		
		만약 import에서 
		import ch06.exam15.pack1.*;
		import ch06.exam15.pack2.B;
		이렇게 둘중하나가 *가 아닌 지정이면 에러가 안남
		*/
		//여튼 이렇게 정확히 지정해줘야 에러가 안남
		ch06.exam15.pack1.C c = new ch06.exam15.pack1.C(); 
	}
}
