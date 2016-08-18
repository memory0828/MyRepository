package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		/*
		문제 :
 		x는 1부터 10 사이의 정수
		y는 1부터 10 사이의 정수
		4x+5y=60;
		x값과 y값을 (x,y)로 출력하시오
		
		작성자 : 유호선
		*/
		
		
		
		int x = 0; //x 변수 선언
		int y = 0; //y 변수 선언
		int sam = 0; //방정식 계산 변수 선언
	
		//중첩 for문 없이 해당 결과값 얻기
		for(x=1; x<=10; x++){
			y = 1;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 2;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}			
			
			y = 3;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 4;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 5;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 6;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 7;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}			
			
			y = 8;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}
			
			y = 9;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}			
			
			y = 10;
			sam = 4*x + 5*y;
			if( sam == 60){
				System.out.println( "("+x+","+y+")" );
			}

		}
		
	}

}
