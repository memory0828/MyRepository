package ch04.exam02;

public class WhileExample6 {

	public static void main(String[] args) throws Exception {
		int save = 0;
		int in=0;
		boolean sw = true;
		
		while(sw){
			if(in != 13 && in != 10){
				System.out.println("--------------------------");
				System.out.println("1. 예금 | 2. 출금 | 3.종료");
				System.out.println("--------------------------");
				System.out.print("선택 : ");
			}
			
			in = System.in.read();	
			
			if( in == 49){
				save+=1000;
				System.out.println("현재 잔액 :" + save + "원");
			}else if ( in == 50){
				save-=500;
				System.out.println("현재 잔액 :" + save + "원");
			}else if ( in == 51){
				sw = false;
				System.out.println("프로그램종료");
			}
		}
		
		
	
	}

}
