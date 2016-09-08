package ch13.exam04;

//public class HashMap implements Map<K, V> {
//여기서 에러나는 이유 : 항상 컴파일러는 앞에있는 타입 파라미터를 보고 뒷 내용을 결정하는데, 앞에 없으니깐 에러난다
//그래서 다음과 같이 앞으로 파라미터부분을 빼서 넣고
//public class HashMap<K, V> implements Map<K, V> {
//또 여기서 에러나는 이유? 인터페이스가 가지는 메소드가 구현되지 않았기 때문에
//그래서 메소드를 구현한다.
//도큐먼트에 있는 HashMap과 Map인터페이스는 이런식으로 만들어졌지

//제네릭 인터페이스를 구현한 클래스
public class HashMap<K, V> implements Map<K, V> {
	private K k;
	private V v;
		
	@Override
	public void add(K k, V v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public V get(K k) {
		if(this.k == k) { return this.v; }
		return null;
	}
}

