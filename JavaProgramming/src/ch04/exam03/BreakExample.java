package ch04.exam03;

public class BreakExample {

	public static void main(String[] args){
		//주사위의 눈이 6이 나오면 프로그램을 종료하세요
			
		System.out.println("= 시작==============");
		do{
			int ju = (int)(Math.random() * 6)+1;
			System.out.println("나온 주사위 : " + ju );
			if(ju == 6) break;
		}while(true);
		
		System.out.println("= 종료==============");
	}

}
