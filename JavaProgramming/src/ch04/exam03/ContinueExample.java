package ch04.exam03;

public class ContinueExample {

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		//키보드로부터 1~3사이의 번호 이외의 번호가 입력되면 다시 입력되도록해
		
		while(true){
			System.out.print("키입력 +: ");
			int in = System.in.read();
			if(49 <= in && in <= 51){
				System.out.println("입력된 키번호" + in);
				System.out.println("== 프로그램 종료");
				break;
			}else{
				continue;
			}
		}
		
		
		
		
	}

}
