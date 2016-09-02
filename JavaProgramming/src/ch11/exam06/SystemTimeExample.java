package ch11.exam06;

public class SystemTimeExample {
	public static void main(String[] args) {
		long start = System.nanoTime();
		long start2 = System.currentTimeMillis();
		
		int sum = 0;
		for(int i=1; i<= 1000000; i++){
			sum += i;
		}
		
		long end = System.nanoTime();
		long end2 = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end - start) ); //출력결과 걸린 시간 : 2023915 -> 0.002초가 걸렸다는 말
		System.out.println("걸린 시간 : " + (end2 - start2) ); //단위가 다른거지 쓰임새는 같다
	}
}