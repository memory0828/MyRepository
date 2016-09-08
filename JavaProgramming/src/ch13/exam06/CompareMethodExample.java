package ch13.exam06;

public class CompareMethodExample {
	public static void main(String[] args) {
		//boolean b1 = Util.compare(new Pair<String,String>("이름", "김가을") , new Pair<String,String>("이름","홍길동") );
		//위을 풀어쓰면 아래와 같음
		Pair<String,String> pa1 = new Pair<String,String>("이름", "김가을");
		Pair<String,String> pa2 = new Pair<String,String>("이름", "홍길동");
		Pair<String,String> result = Util.max(pa1, pa2);
		System.out.println(result);

		Pair<String,Integer> pa3 = new Pair<String,Integer>("이름", 10);
		Pair<String,Integer> pa4 = new Pair<String,Integer>("이름", 20);
		Pair<String,Integer> result2 = Util.max(pa3, pa4);
		System.out.println(result2);
	}
}