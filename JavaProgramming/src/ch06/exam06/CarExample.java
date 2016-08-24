package ch06.exam06;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		System.out.println( "company : " + car1.company );
		System.out.println();
		
		Car car2 = new Car("테스트1");
		System.out.println( "company : " + car2.company );
		System.out.println( "model : " +car2.model );
		System.out.println();
	
		Car car3 = new Car("테스트2", "검정");
		System.out.println( "company : " + car3.company );
		System.out.println( "model : " + car3.model );
		System.out.println( "color : " + car3.color );
		System.out.println();
		
		Car car4 = new Car("테스트3", "검정", 100);
		System.out.println( "company : " + car4.company );
		System.out.println( "model : " + car4.model );
		System.out.println( "color : " + car4.color );
		System.out.println( "maxspeed : " + car4.maxSpeed );
		System.out.println();		
	}

}
