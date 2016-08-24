package ch06.exam09;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		int[] aaa = new int[] {1,1,1,1,1,1,1};
		Car testCar = new Car( aaa );
		System.out.println("생성자 실행후 aaa: " + aaa[0]);
		testCar.Set1( aaa );
		System.out.println("Set1 int[] 실행후 aaa: " + aaa[0]);
		testCar.Set2( aaa );
		System.out.println("Set2 int ... 실행후 aaa: " + aaa[0]);		
		int bbb = 10;
		testCar.Set3( bbb );
		System.out.println("Set3 int형 매개변수 전달 실행후 aaa: " + bbb);
		
		String strTemp1 = "기본";
		String[] strTemp2 = { "기본1", "기본2" };
		testCar.Set4( strTemp1 );
		System.out.println("Set4 String형 매개변수전달 실행후 strTemp1: " + strTemp1);
		testCar.Set5( strTemp2 );
		System.out.println("Set5 String형 배열 매개변수전달 실행후 strTemp2: " + strTemp2[0]);
		
		
		myCar.setGas(5);  //Car의 setGas() 메소드 호출
		
		boolean gasState = myCar.isLeftGas();  //Car의 isLeftGas() 메소드 호출
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();  //Car의 run() 메소드 호출
		}
		
		if(myCar.isLeftGas()) {  //Car의 isLeftGas() 메소드 호출
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
		
		
	}

}
