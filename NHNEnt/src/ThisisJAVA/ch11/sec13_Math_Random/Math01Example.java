package ThisisJAVA.ch11.sec13_Math_Random;

public class Math01Example {
	public static void main(String[] args) {
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("절대값(-5) v1=" + v1);
		System.out.println("절대값(-3.14) v2=" + v2);
		System.out.println("===================");
		
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("올림값 v3=" + v3);
		System.out.println("올림값 v4=" + v4);
		System.out.println("===================");
		
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("버림값 v5=" + v5);
		System.out.println("버림값 v6=" + v6);
		System.out.println("===================");
		
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("최대값 v7=" + v7);
		System.out.println("최대값 v8=" + v8);
		System.out.println("===================");
		
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.5);
		System.out.println("최소값 v9=" + v9);
		System.out.println("최소값 v10=" + v10);
		System.out.println("===================");
		
		double v11 = Math.random();
		System.out.println("램덤값 v11=" + v11);
		System.out.println("===================");
		
		double v12 = Math.rint(5.3);
		double v13 = Math.rint(5.7);
		System.out.println("가까운 정수의 실수값(5.3) v12=" + v12);
		System.out.println("가까운 정수의 실수값(5.7) v13=" + v13);
		System.out.println("===================");
		
		long v14 = Math.round(5.3);
		long v15 = Math.round(5.7);
		System.out.println("반올림값(5.3) v14=" + v14);
		System.out.println("반올림값(5.7) v15=" + v15);
		System.out.println("===================");
		
		//round는 항상 소수점 첫째자리에서 반올림되는데
		//원하는자리에서 반올림하기 위한 코드
		double value = 12.3456;
		System.out.println("원래 : " + value);
		double temp1 = value * 100;
		System.out.println("100곱함 : " + temp1);
		long temp2 = Math.round(temp1);
		System.out.println("위에서 소스첫째 반올림 : " + temp2);
		double v16 = temp2 / 100.0;
		System.out.println("100다시 나눠서 원래대로 v16=" + v16);
	}
}
