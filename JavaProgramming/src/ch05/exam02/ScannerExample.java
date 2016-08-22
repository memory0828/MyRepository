package ch05.exam02;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수 입력 : ");
		int num = Integer.parseInt(scanner.nextLine());
		String[][] scores = new String[num][2];
		
		for(int i=0; i<scores.length; i++){
			System.out.print("이름 : ");
			String name = scanner.nextLine();
			System.out.print("점수 : ");
			String score = scanner.nextLine();
			String[] arr = { name, score };
			scores[i] = arr;
		}
		
		while(true){
			System.out.println("======================");
			System.out.println("1.최고점수 | 2. 평균 | 3.종료");
			System.out.println("======================");
			System.out.print("선택 : ");
			int choice = Integer.parseInt(scanner.nextLine());
			if(choice == 1){
				System.out.println("최고점수 선택 :  ");
				int max = 0;
				for(String[] arr : scores){
					int p = Integer.parseInt(arr[1]);
					if (max < p ) max = p;					
				}
				
				for(String[] arr : scores){
					int p = Integer.parseInt(arr[1]);
					if (max == p){
						System.out.println("이름 : " + arr[0] + " / 점수 : " + arr[1]);
					}
				}

			}else if(choice == 2){
				System.out.print("평균 선택 :  ");
				int sum = 0;
				float avg = 0.0f;
				for(String[] arr : scores){
					int p = Integer.parseInt(arr[1]);
					sum += p;
				}
				avg = (float)sum / scores.length; 
				System.out.println(avg);				
				
			}else if(choice == 3){
				System.out.print("프로그램 종료  ");
				break;
			}else{
				System.out.println("1 ~ 3 의 값을 입력하시오 ");
			}
		}
		
		
		
		

	}

}
