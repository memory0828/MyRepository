package ch04.exam01;

public class IfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 92;
		
		boolean result = false;
		
		if (score > 90){
			System.out.println("A 등급");
		}else if(score > 80) {
			System.out.println("B 등급");		
		} else {
			System.out.println("C 등급");
		}
		
		System.out.println("끝");
	}

}
