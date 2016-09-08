package ch13.exam06;

public class Util {
	public static void compare2(Pair<Integer, Integer> p5, Pair<Integer, Integer> p6){}
	public static void compare3(Pair<String, String> p1, Pair<String, String> p2){}
	
	//이런소스가 아래 하나로 다 처리됨! 이것이 제너릭!
                   	//↓반환형 앞에 써줌. 미리 알려주는거~ 멀 의미하는지 앞에서 다 설명했음 ㅋ
	public static <K,V> boolean compare(Pair <K,V>p1, Pair <K,V>p2){
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare; 
	}
	
	public static <K,V> Pair<K,V> max(Pair<K,V> p1, Pair<K,V>p2){
		return p2;
	}
	
}
