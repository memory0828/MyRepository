package ch18.exam07;

import java.io.Console;
public class ConsoleExample {
	public static void main(String[] args) {
		Console cs = System.console();
		
		System.out.println("아이디 : ");
		String id = cs.readLine();
		
		System.out.println("패스워드 : ");
		char[] values = cs.readPassword();
		String pass = new String(values);
		//아무것도 입력안된것처럼 보일뿐 그러나 입력은되고있음

		System.out.println("입력된 내용");
		System.out.println(id);
		System.out.println(pass);
		/*
		 * 인풋스트림을 통해서 하려면 여러가지 해야해서 불편함
		 * 그래서 콘솔로하면 간편한데
		 * 콘솔의 단점은 다양한 데이터 타입을 받을 수 없다. 즉 콘솔을 통해서 곧바로 숫자같은걸 못받고, 변환해서 사용해야함
		 * 그래서 Scanner가 있다 
		 */		
	}
}
