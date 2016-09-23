package ch15.exam05;

import java.util.*;
public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		//트리셋은 추가될때마다 내부적으로 작은놈은 왼쪽 / 큰놈은 오른쪽으로 자동정렬되어 저장 됨
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		System.out.println("제일작은값 : " + scores.first());
		System.out.println("제일큰값 : " + scores.last());
		
		//95를 포함하지않는 가장 가까운 점수중에서 95보다 바로 밑
		System.out.println("나를 포함안하는 가까운 밑의 값 : " + scores.lower(95));
		//95를 포함하지 않는 가장 가까운 값중에 95보다 바로 위
		System.out.println("나를 포함안하는 가까운 위 값 : " + scores.higher(95) ); 
				
		//95를 [포함하는] 가장 가까운 값중에 95보다 바로 위
		System.out.println("나를 포함하는 가까운 밑의 값 : " + scores.floor(95)); 
		//95를 [포함하는] 가장 가까운 점수중에서 95보다 바로 밑
		System.out.println("나를 포함하는 가까운 위 값 : " + scores.ceiling(95)); 
		
		//정렬1 - 내림차순
		NavigableSet<Integer> dSet = scores.descendingSet(); //이렇게하면 정렬이된 NavigableSet을 dSet에 받을 수 있다 
		for(Integer s : dSet){
			System.out.print(s + "/"); //내림차순으로 출력
		}
		System.out.println();
		//오른차순으로 하려면? 어센딩이라는 메소드는 없고 ㄸ 디센딩한놈을 또 디센딩하면 오름차순이 됨 ㄸ
		//정렬2 - 오른차순
		NavigableSet<Integer> aSet1 = dSet.descendingSet();
		//아니면 아애 첨부터 이렇게 해도됨
		//NavigableSet<Integer> aSet1 = scores.descendingSet().descendingSet();
		for(Integer s : aSet1){
			System.out.print(s + "/"); //오름차순으로 출력
		}
		System.out.println();
		
		//검색
		TreeSet<String> words = new TreeSet<String>();
		words.add("apple");
		words.add("forever"); //f가 아닌 forever는 f를 벗어남음에 아래 검색단어에 포함안됨 
		words.add("description");
		words.add("ever");
		words.add("zoo");
		words.add("base");
		words.add("guess");
		words.add("cherry");
		NavigableSet<String> aSet2 = words.descendingSet().descendingSet();
		for(String s : aSet2){
			System.out.print(s + ", "); //오름차순
		}
		System.out.println();		
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableSet<String> rangeSet = words.subSet("c", true, "f", true); //c <= 검색단어 <= f
		for(String word : rangeSet) {
			System.out.print(word + ", ");
		}		
	}
}
