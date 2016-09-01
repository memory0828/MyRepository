package ch09.exam04;

public class A {
	int field;
	static B b;
	
	public A(){
		B b = new B(); //어 에러가 안나네? 보통 생성자가 끝나야 객체가 만들어 지니깐 이거 에러 나야하는데?
		//에러가 안나는 이유는
		//생성자는 객체 사용전에 준비시켜주는 역할을 한다
		//즉 생성자 전에 객체는 만들어지는데, 근데 생성자는 객체 사용전에 준비시켜주는 역할을 함으로
		//실행도중에 에러가나면 객체는 생성이 안된다.
		//그.래.서. 위 코드가 에러가 안난다
		//보통 생성자가 끝나야 객체가 만들어 진다고 생각하는데, 이제 개념을 다시 잡자
	}
	
	public A(int field){
		this.field = field;
		B b = new B();
		//그동안 무심코 사용했던~ this.field = field; 
		//이것도 생성자가 끝나야 객체가 만들어진다면 에러가 났을꺼다
		//근데 에러가 안나지!
		//결국 위 설명의 재확인이다. 

	}
	
	public class B{
		int field1;
		void method1(){}
	}
}
