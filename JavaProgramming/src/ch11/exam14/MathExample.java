package ch11.exam14;

import java.util.Arrays;
public class MathExample {
	public static void main(String[] args) {
		//로또 번호생성기
		int[] lotto = new int[7];
		for(int i=0; i<lotto.length; i++){
			lotto[i] = (int)(Math.random() * 45)+1;			
		}
		System.out.println(Arrays.toString(lotto));
	}
}
