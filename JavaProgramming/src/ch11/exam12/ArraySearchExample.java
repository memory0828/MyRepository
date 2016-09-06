package ch11.exam12;

import java.util.Arrays;

public class ArraySearchExample {
	public static void main(String[] args) {
		//기본 타입값 검색
		int[] scores = { 99, 97, 98 };
		//1. sort
		Arrays.sort(scores); 
		//2. 반드시 1다음에 binarySearch : ★이걸하기전에 sort를 한번해줘야 제대로된 결과값이 나옴
		int index = Arrays.binarySearch(scores, 99);  
		System.out.println("찾은 인덱스: " + index);
		
		//문자열 검색
		String[] names = { "홍길동", "박동수", "김민수" };
		//1. sort
		Arrays.sort(names); //String는 기본적으로 compareTo를 지원해서 바로 sort를 쓸수있당
		//2. 반드시 1다음에 binarySearch
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스: " + index);
		
		//객체 검색
		Member m1 = new Member("홍길동"); //★이런 형태로 쓸수있는 클래스를 만들어라 시험문제 나온다하심
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = { m1, m2, m3 };
		//1. sort
		Arrays.sort(members); //Member클래스안에 comparableTo를 재정의했음
		//2. 반드시 1다음에 binarySearch
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스: " + index);
	}
}
