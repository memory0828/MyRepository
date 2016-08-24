package ch06.exam08;

public class CaluculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator ca1 = new Calculator();
		ca1.powerOn();
		System.out.println(ca1.plus(1, 2));
		System.out.println(ca1.dec(10, 6));
		ca1.PowerOff();;
	}

}
