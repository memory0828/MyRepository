package ch05.exam02;

import java.util.Scanner;

public class ScoreManagement2 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] students = null;

		while(true){
			System.out.println("=========================================================================");
			System.out.println("1.총학생수 | 2.목록 | 3. 입력 | 4. 삭제 | 5. 최고점수 | 6. 평균 | 7.종료");
			System.out.println("=========================================================================");
			System.out.print("선택 : ");

			String choice = scanner.nextLine();
			if ( choice.equals("1") ){
				//1 입력 : 총학생수 입력
				System.out.print("총학생수 입력 : ");	
				students = new String[Integer.parseInt(scanner.nextLine())][];
			}else if ( choice.equals("7") ){
				//7 입력 : 종료
				System.out.println("프로그램 종료");
				break;
			}else{
				//2~ 입력
				if(students == null){
					//예외처리
					System.out.println("Error : 총학생수부터 입력하세요");	
				}else{
					if ( choice.equals("2") ){
						//2 입력 : 목록 출력
						System.out.println("=========================================================================");
						System.out.println("no / [학번]" + "\t\t\t[이름]" + "\t\t\t[점수]");
						System.out.println("=========================================================================");
						int cnt = 0;
						for(String[] arr : students){
							if(arr != null){
								System.out.println("학번 : " + arr[0] + "\t\t이름 : " + arr[1] + "\t\t점수 : " + arr[2]);
							}
						}
					}else if ( choice.equals("3") ){
						//3 입력 : 데이터 입력
						System.out.println("총 " + students.length + "명의 저장공간에서 빈곳에 입력 중" );
						for(int i=0; i<students.length; i++){
							if(students[i] == null){
								System.out.println("학번 : " + i + "으로 배정된");
								System.out.print(" - 학생의 이름 입력 : ");
								String name = scanner.nextLine();
								System.out.print(" - 학생의 점수 입력 : ");
								String point = scanner.nextLine();
								String[] arr = {String.valueOf(i), name, point}; 
								students[i] = arr;
								break;
							}
						}
						
					}else if ( choice.equals("4") ){
						//4 입력 : 삭제
						System.out.print("삭제하려는 학생의 학번 : ");
						String strTarget = scanner.nextLine();
						
						for(int k=0; k<students.length; k++){
							 if(students[k] != null &&  strTarget.equals(students[k][0])){
								 System.out.print("삭제대상은 : "+ students[k][0] + "\t" + students[k][1] + "\t" + students[k][2] + "입니다. 삭제하시겠습니까?(y or n) : ");
								 if(scanner.nextLine().equals("y")){
									 students[k] = null;
									 System.out.println("삭제 OK! ");			 
								 }else{
									 System.out.println("삭제 Cancel!");
								 }
							 }
						}
	
					}else if ( choice.equals("5") ){
						//5 입력 : 최고점수
						int max = 0;					
						for(String[] arr : students){
							if(arr != null){
								int p = Integer.parseInt(arr[2]);
								if ( max < p ) max = p;
							}
						}
						System.out.println("최고점수 : " + max);
						
						for(int k=0; k<students.length; k++){
							if(students[k] != null){
								int p = Integer.parseInt(students[k][2]);
								if ( max == p ){
									System.out.println("최고점수 학생 : "+ students[k][0] + "\t\t" + students[k][1] + "\t" + students[k][2]);
								}
							}
						}

					}else if ( choice.equals("6") ){
						//6 입력 : 평균
						int sum = 0;
						int cnt = 0;
						float avg = 0.0f;
						for(String[] arr : students){
							if(arr != null){
								int p = Integer.parseInt(arr[2]);
								sum+=p;
								cnt++;
							}
						}
						avg = (float)sum / cnt;
						System.out.println("평균 : " + avg);
						
					}else{
						System.out.println("Error : 1~7 값만 입력하세요");
					}
				}
			}
		}//while 종료
		
	}

}
