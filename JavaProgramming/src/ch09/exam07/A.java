package ch09.exam07;
//중첩된 클래스 내에서 밖같의 클래스의 필드나 메소드에 접근하고 싶으면
public class A {
	int field;
	
	public void method(){
		class B{
			int field;
			B(){
				field = 20;
				this.field = 30; //B의 int field; 의 접근
				A.this.field = 40; //A의 int field; 의 접근
			}
			
		}
	}
}
