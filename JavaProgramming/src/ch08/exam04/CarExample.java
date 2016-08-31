package ch08.exam04;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		myCar.t[0] =new KumhoTire();
		myCar.t[1] =new KumhoTire();

		myCar.run();
		

	}

}
