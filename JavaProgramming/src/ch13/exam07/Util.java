package ch13.exam07;

public class Util {
	public static <T extends Number> int compare(T t1, T t2){
		//Number을 상속받은 것들만 T가 될수있음
		double v1 = t1.doubleValue();
		double v2 = t1.doubleValue();
		
		return Double.compare(v1, v2);
		/*
		 * 위 return은  아래와 같은 의미
		if(v1 < v2) return -1;
		else if(v1 == v2) return 0;
		else return 1;
		 */
	}
}
