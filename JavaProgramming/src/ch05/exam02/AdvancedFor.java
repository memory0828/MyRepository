package ch05.exam02;

public class AdvancedFor {

	public static void main(String[] args) {
		int[] scores = {90, 92, 95};
		
		int sum = 0;
		for(int score : scores){
			sum+=score;
		}
		System.out.println(sum);
		
		String[][] names = { {"자바","C언어","파이썬"}, {"자바2","C언어2","파이썬2"} };
		for(String name : names[1]){
			System.out.println(name);
		}

	}

}
