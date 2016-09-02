package ch11.exam02;
import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		Key key1 = new Key(1);
		Key key2 = new Key(1);
		
		System.out.println(key1 == key2); //false
		System.out.println(key1.equals(key2)); //true : 재정의했기때문에
		System.out.println(key1.hashCode() == key2.hashCode()); //true 해쉬값 재정의해서 number값을 리턴하게했기때문에
		
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		// 타입명                  변수명     =        생성자
		
		//잘모르겠음
		hashMap.put(key1, "홍길동");
		hashMap.put(key2, "감자바");
		System.out.println(hashMap.size());
	}
}
