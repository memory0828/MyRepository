package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {
		/*		
		문제 :
		1. 주사위를 2개를 100번을 던진다
		2. 두 주사위의 눈의 합이 10이 될 때
		3. (주사위1눈, 주사위2눈)으로 출력하시오
		(5,5)
		(6,4)
		(4,6)
		작성자 : 유호선*/
		
		for(int i=1; i<=100; i++){
			int j1 = (int)(Math.random() * 10) + 1;
			int j2 = (int)(Math.random() * 10) + 1;
			int sam = j1 + j2 ;

			if(sam == 10){
				//주사위 눈의 합이 10일 때만 실행
				System.out.println("("+j1+","+j2+")");
			}
		}
		
	}

}
