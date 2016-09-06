package ch11.exam13;

public class CompareValueExample {
	public static void main(String[] args) {
		//정상
		System.out.println("[-128~127 초과값일 경우]");
		Integer obj1 = 500;
		Integer obj2 = 500;
		System.out.println("==결과: " + (obj1 == obj2)); //false - 다른 참조변수니깐
		//intValue() 값을 언박싱하는 메소드
		System.out.println("언박싱후 ==결과: " + (obj1.intValue() == obj2.intValue())); //true - 500과 500이 비교되니 
		System.out.println("equals() 결과: " + obj1.equals(obj2)); 
		System.out.println();
		
		//예외(비정상) 주의!!!!!
		System.out.println("[-128~127 범위값일 경우]");
		Integer obj3 = 100;
		Integer obj4 = 100;
		System.out.println("==결과: " + (obj3 == obj4)); //true ???? 이거 논리적으로 분석안됨(비정상...)
		//이유 p532의 표참고 / 그러나 이 위의 방식으로 값비교가 된다해도 이렇게 하면 안되고
		//Wrapper(포장) 객체안의 값을 비교할경우에는
		//1 아래와 같이 반드시, intValue()로 언박싱해서 값을 비교해하거나
		System.out.println("언박싱후 ==결과: " + (obj3.intValue() == obj4.intValue())); //true
		//2. 재정의된(...알지?) equals를 통해서 비교해라!
		System.out.println("equals() 결과: " + obj3.equals(obj4));
	}
}
