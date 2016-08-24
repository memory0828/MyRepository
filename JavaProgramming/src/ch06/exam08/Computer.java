package ch06.exam08;

public class Computer {
	int sum1(int[] val){
		int sum = 0;
		for(int d : val) sum+= d;
		return sum;
	}
	
	int sum2(int ...val){
		int sum = 0;
		for(int d : val) sum+= d;
		return sum;
	}
}
