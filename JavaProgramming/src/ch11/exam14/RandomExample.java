package ch11.exam14;

import java.util.Arrays;
import java.util.Random;
public class RandomExample {
	public static void main(String[] args) {
		Random r1 = new Random();
		Random r2 = new Random(3); //3은 시드값 : 램던의 객체가 나중에 난수를 발생시킬떄 사용하는 알고리즘에 이용
		Random r3 = new Random(3);
		
		System.out.println(r1.nextInt()); //혼자만다름
		System.out.println(r2.nextInt()); //r2,r3의 nextInt는 동일한 결과값이 나옴
		System.out.println(r3.nextInt()); //r2,r3의 nextInt는 동일한 결과값이 나옴
		
		//주사위 번호
		int num = r1.nextInt(6) + 1;
		System.out.println(num);
	}
}