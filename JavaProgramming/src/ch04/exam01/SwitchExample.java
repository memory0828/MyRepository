package ch04.exam01;

public class SwitchExample {

	public static void main(String[] args) {
		
/*		double d = Math.random();
		d = d * 6;
		int num = (int)d;
		num = num +1;*/

		int num = (int)( Math.random() * 6)+1;

		switch(num){
		case 1:
			System.out.println("1번");
		case 2:
			System.out.println("2번");
		case 3:
			System.out.println("3번");
		case 4:
			System.out.println("번");
			break;
		case 5:
			System.out.println("5번");
			break;
		default:
			System.out.println("6번");
			break;
		}
	}

}
