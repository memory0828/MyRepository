package ch11.exam05;

public class GcExample {
	public static void main(String[] args) {
		Employee emp = new Employee(1);
		emp = null; //위에서 만들어진 객체는 이코드을 만나면서 쓰레기 객체가 된다
		emp = new Employee(2);
		emp = new Employee(3);
		
		System.gc(); //가비지 컬랙팅 : 쓰래기 객체를 지워라
		//JVM이 시스템이 한가할떄, 시스템이 메모리가 부족하다고 판단될때, 이 지시를 호출하면 정리가 들어간다
		//근데 지시를 호출하지 않아도 자동적으로 호출하게 된다
		//근데 지시를 호출하면 JVM이 가급적 별 이유가 없는한 쓰래기 객체정리를 한다.
		//자동으로 제거되는데 만약 제거되는 순간을 알고싶다면 어떻게 할까? 
		//Employee에서 finalize를 이렇게 제정의을 통해 안다
	}
}
