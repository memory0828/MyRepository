package ThisisJAVA.ch11.sec11_Arrays;

import java.util.Arrays;

public class Arrays03SortExample {
	public static void main(String[] args) {
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		for(int i=0; i<scores.length; i++) {
			System.out.println("scores[" + i + "]=" + scores[i]);
		}
		System.out.println();
		
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		for(int i=0; i<names.length; i++) {
			System.out.println("names[" + i + "]=" + names[i]);
		}
		System.out.println();
		
		Arrays03_Member m1 = new Arrays03_Member("홍길동");
		Arrays03_Member m2 = new Arrays03_Member("박동수");
		Arrays03_Member m3 = new Arrays03_Member("김민수");
		Arrays03_Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		for(int i=0; i<members.length; i++) {
			System.out.println("members[" + i + "].name=" + members[i].name);
		}
	}
}
