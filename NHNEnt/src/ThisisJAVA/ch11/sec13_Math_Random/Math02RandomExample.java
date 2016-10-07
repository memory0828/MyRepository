package ThisisJAVA.ch11.sec13_Math_Random;


public class Math02RandomExample {
	public static void main(String[] args) {
		//random으로 주사위 눈 만들기
		int num = (int) (Math.random()*6) + 1;
		System.out.println("주사위 눈: " + num);
	}
}

