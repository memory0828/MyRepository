package ch06.exam04;

public class Person {
	//Field
	String name;
	String sex;
	int age;
	double height;
	boolean married;
	
	//Constructor
	Person(String name, String sex, int age){
		this.name = name; //객체의 필드를 지정하는것 this
		this.sex = sex;
		this.age = age;
		//name = "1";  이럴경우 필드에 name이 있고, 매개변수에도 name이있을때, 이렇게 사용하면 가까운쪽인 매개변수 name이 사용됨
		//this.name = "2"; 이럴경우 필드에 name이 있고, 매개변수에도 name이있을때, 이렇게 사용하면 필드 name이 사용됨
	}
	
	//Method
}
