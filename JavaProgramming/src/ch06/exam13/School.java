package ch06.exam13;

public class School {
	//Field
	//private를 통해 함부로 접근 못하도록 싱글톤으로 만들고
	private static School singleton = new School();
	//Consturctor
	private School(){
	}
	//Method
	static School getInstance(){
		//그 싱글톤으로 만든 하나만 만들어지는 객체를 외부에서 사용하도록 반환값을 받을수있는 코드를 넣어줌
		//여긴 외부에서도 사용해야함으로 private는 일부로 안넣음
		return singleton;
	}
}
