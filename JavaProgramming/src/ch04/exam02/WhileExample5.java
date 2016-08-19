package ch04.exam02;

public class WhileExample5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		while(run){
			if(keyCode != 13 && keyCode != 10){
				System.out.println("------------------------");	
				System.out.println("1. 증속 | 2. 감소 | 3. 멈춤");
				System.out.println("------------------------");
				System.out.print("선택 : ");
			}
			keyCode = System.in.read();
	
			switch (keyCode){
			case 49:
				speed++;
				System.out.println("현재속도 : " + speed);
				break;
			case 50:
				speed--;
				System.out.println("현재속도 : " + speed);					
				break;				
			case 51:
				run=false;					
				break;	
			}
		}
	}

}
