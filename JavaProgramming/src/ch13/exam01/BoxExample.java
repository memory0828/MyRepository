package ch13.exam01;

import java.util.Date;
public class BoxExample {
	public static void main(String[] args) {
		Box box1 = new Box();
		box1.set("홍길동");
		String name = (String) box1.get(); //Object로 만들어졌기때문에 형변환을 해야함ㅠ
		
		Box box2 = new Box();
		box2.set(10); //기본형인 int가 저장되는게 아니라 Integer객체가 만들어지고 그 객체가 가진 참조번지가 넘어간다
		int value = (Integer)box2.get(); //Object로 만들어졌기때문에 형변환을 해야함ㅠ
		
		Box box3 = new Box();
		box3.set(new Date());
		Date now = (Date)box3.get(); //Object로 만들어졌기때문에 형변환을 해야함 ㅠ
		//근데 이 아래서부터
		String now2 = (String)box3.get(); //어? Date형을 가져올건데 컴파일러에서 에러가 안남..
												  // 나중에 실행하다 클래스캐스터 입셉션 에러생김 ㅠ 
		//그래서 이런 부분을 개선하기 위해 제너릭이 필요하지!
	}
}
