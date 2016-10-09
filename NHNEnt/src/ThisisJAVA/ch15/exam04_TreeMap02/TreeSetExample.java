package ThisisJAVA.ch15.exam04_TreeMap02;

import java.util.*;
public class TreeSetExample {
	public static void main(String[] args) {
		//===== Comparable이 태생부터 구현된 경우
		TreeSet<Person> tSet1 = new TreeSet<>(); //비교기능이 있기 때문에
		tSet1.add(new Person("홍길동", 25)); //아무 문제없음
		tSet1.add(new Person("감자바", 30)); 
		tSet1.add(new Person("박동수", 21)); 
		NavigableSet<Person> pSet = tSet1.descendingSet().descendingSet();
		for(Person s : pSet){
			System.out.print(s + "/"); //오름차순으로 출력
		}
		System.out.println();
		
		//===== Comparator을 구현해야 하는 경우
		//TreeSet<Fruit> tSet2 = new TreeSet<>(); //앞에서 이론으로 배웠듯이 선언에서는 에러가 안나지만
		//tSet2.add(new Fruit("사과", 3000)); //저장할 때 에러발생 왜? 비교기능이 없으니깐
		//그래서 이 문제를 해결하기 위해 Comparator을 부여한 객체를 하나 만들어서 생성자에 넣어주면 됨
		//그냥 Fruit을 수정하면 되지 않냐? 맞지만.. 실무에서 남이 만들어놓은걸 써야하는경우 도 있음에~ 수정못할경우 우회방법이지
		TreeSet<Fruit> tSet2 = new TreeSet<>(new FruitComparator());
		tSet2.add(new Fruit("사과", 3000)); 
		tSet2.add(new Fruit("복숭아", 5000));
		tSet2.add(new Fruit("포도", 2500));
		NavigableSet<Fruit> fSet = tSet2.descendingSet().descendingSet();
		for(Fruit s : fSet){
			System.out.print(s + "/"); //오름차순으로 출력
		}
		System.out.println();		
	}
}
