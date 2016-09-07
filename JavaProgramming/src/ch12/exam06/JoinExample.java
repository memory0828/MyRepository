package ch12.exam06;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		SumThread sumT = new SumThread();
		// 이상태는 스레드가 종료될떄 값이 나올수도있고 아닐수도있어서 정확한 결과값을 얻을수없다
		/*
		sumT.start();
		System.out.println("1~100합 : " + sumT.getSum());
		*/
		//그래서
		//이렇게 하면 
		sumT.start();
		sumT.join(); //sumT가 종료될떄까지 기다리는거니깐 곧 main메소드가 기다리는거임
		System.out.println("1~100합 : " + sumT.getSum()); //정확한 결과값이 나옴
	}
}
