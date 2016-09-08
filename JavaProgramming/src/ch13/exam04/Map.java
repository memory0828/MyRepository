package ch13.exam04;

//제네릭 인터페이스
public interface Map<K, V> {
	//이런 메소드들을 제네릭 메소드라고함
	void add(K k, V v); 
	//이런 메소드들을 제네릭 메소드라고함
	V get(K k);
}
