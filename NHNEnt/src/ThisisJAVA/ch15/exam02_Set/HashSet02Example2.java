package ThisisJAVA.ch15.exam02_Set;

import java.util.*;
public class HashSet02Example2 {
	public static void main(String[] args) {
		Set<HashSet02Member> st = new HashSet<>();
		HashSet02Member m1 = new HashSet02Member("홍길동", 25);
		HashSet02Member m2 = new HashSet02Member("홍길동", 25);
		
		System.out.println("m1 해쉬코드 : " + m1.hashCode());
		System.out.println("m2 해쉬코드 : " + m2.hashCode());
		
		st.add(m1);
		st.add(m2);
		System.out.println(st.size()); //2 해쉬코드가 다르니깐 다른객체로 취급해서 저장됨
	}
}
