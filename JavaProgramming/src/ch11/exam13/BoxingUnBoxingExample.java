package ch11.exam13;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		//Boxing
		Integer obj0 = 100; //해석 : 100을 넣는다가아님. 100이라는 값을 Wrapper(포장) 객체(Integer)로 만들어서 박싱하고, 그 번지를 obj0에 넣는다
		//Unboxing
		int value = obj0; //Wrapper(포장) 객체 안에 있는, 값 100을 꺼내어서 그 값을 int value에 저장한다
		int result = obj0 + 200; //Wrapper(포장) 객체 안에 있는 100을 끄집어 내어서 200과 합친뒤 그 값을 int result에 넣는다.
		
		//참고 수업중에난 안다룸
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = Integer.valueOf("300");		

		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
	}
}
