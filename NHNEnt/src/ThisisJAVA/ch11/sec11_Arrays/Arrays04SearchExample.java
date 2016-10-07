package ThisisJAVA.ch11.sec11_Arrays;

import java.util.Arrays;

public class Arrays04SearchExample {
	public static void main(String[] args) {
		//배열 검색하려면 일단 sort된 자료야만함
		
		//기본 타입값 검색
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("찾은 인덱스: " + index);
		
		//문자열 검색
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스: " + index);
		
		//객체 검색
		Arrays03_Member m1 = new Arrays03_Member("홍길동");
		Arrays03_Member m2 = new Arrays03_Member("박동수");
		Arrays03_Member m3 = new Arrays03_Member("김민수");
		Arrays03_Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스: " + index);
	}
}