package ch11.exam08;

public class ClassExample {
	public static void main(String[] args) throws ClassNotFoundException {
		//로딩된 정보 알아내는 방법1 - 가장쉬운방법
		//이미로딩이 되어있는 클래스를 가져와서 정보를 알아내는  방법
		Class classCar = Car.class; //Car이 메모리에 로딩되었을때 그정보를 넣음
		System.out.println(classCar.getName());
		System.out.println(classCar.getSimpleName());
		System.out.println(classCar.getPackage().getName());
		
		//로딩된 정보 알아내는 방법2
		//로딩이 안되어 있어도 상관없다. 이 Class.forName("ch11.exam08.Car"); 를 통해 로딩되서 정보를 가져옴,알아냄 
		// 이 아래 코드가 일반예외기 때문에 메인 메소드에  throws ClassNotFoundException를 추가한다
		Class classCar2 = Class.forName("ch11.exam08.Car");
		System.out.println(classCar2.getName());
		System.out.println(classCar2.getSimpleName());
		System.out.println(classCar2.getPackage().getName());
		
		//로딩된 정보 알아내는 방법3
		Car car = new Car();
		Class classCar3 = car.getClass();
		System.out.println(classCar3.getName());
		System.out.println(classCar3.getSimpleName());
		System.out.println(classCar3.getPackage().getName());		

		//위에 3가지 방법은 다 고르게 쓰인다~
	}
}
