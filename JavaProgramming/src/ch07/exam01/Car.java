package ch07.exam01;

public class Car extends Machine{
	//Constructor
	
	static{
		System.out.println("Car static 실행됨");
	}
	public Car(){
		System.out.println("Car() 실행됨");	
	}
}
