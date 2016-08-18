package ch04.exam02;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		int count = 0; 
		float avg = 0.0f;
		
		for(int i = 0; i<3; i++ ){
			int ju = (int)(Math.random() * 6) + 1;
			System.out.println("나온주사위 : " + ju);						
			sum = sum + ju;
			count+=i;
		}
		avg = (float)sum / count;
		System.out.println("총합 : " + sum);
		System.out.println("주사휘 던진 횟 수 : " + count);		
		System.out.println("평균 : " + avg);
	}

}
