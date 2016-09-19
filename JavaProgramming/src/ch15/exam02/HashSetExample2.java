package ch15.exam02;

import java.util.*;
public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> st = new HashSet<>();
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("홍길동", 25);
		
		System.out.println("m1 해쉬코드 : " + m1.hashCode());
		System.out.println("m2 해쉬코드 : " + m2.hashCode());
		
		st.add(m1);
		st.add(m2);
		System.out.println(st.size()); //2 해쉬코드가 다르니깐 다른객체로 취급해서 저장됨
	}
}
