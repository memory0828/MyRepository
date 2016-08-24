package ch06.exam08;

public class MathExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math math = new Math();
		math.printInfo("수학객체 생성");
		math.max(6,  4); //이것도 가능함(실행하지만 리턴값은 안받겠다는 의미) 
		int re1 = math.max(6,  4);
		System.out.println(re1);
		
		//배열을 매개변수로 넘길때 사용하는 방식
		int[] values = { 10,20,30,40,50 };
		double re2 = math.avg1(values);
		double re3 = math.avg2(10,20,30,40,50,60);
		
	}

}
