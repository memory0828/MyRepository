package ch05.exam02;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수 입력 : ");
		int[] scores = new int[Integer.parseInt(scanner.nextLine())];
		
		for(int i=0; i<scores.length; i++){
			System.out.print("입력 : ");
			String value = scanner.nextLine();
			int score = Integer.parseInt(value);
			scores[i] = score;
			
		}

		int sum = 0;
		float avg = 0;
		for(int score:scores){
			sum+=score;
		}
		avg = (float)sum / scores.length;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
