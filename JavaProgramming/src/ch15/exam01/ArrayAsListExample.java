package ch15.exam01;

import java.util.*;
public class ArrayAsListExample {
	public static void main(String[] args) {
		/*이건 리스트를 구현한 객체를 만들긴 만든거지만
		 * arraylist가 아니다.
		 * 이 안에 배열이 들어가있는(길이 3짜리) 것을 만든거다. 그래서 추가나 삭제가 안됨
		 * 즉 이렇게 만든 건 고정된 항목만 가지고 사용할 경우에 사용한다. 
		 */
		List<String> list = Arrays.asList("Java","Jdbc","Database");
			//아래는 1,2,3이 int가 아니라 Integer로 들어간다. 자동박싱이 되서이기도 하지만
			//List는 앞에서 다룬 개념상으로 객체의 번지가 들어가야함으로 값이 직접들어갈수 없기때문이다.
			//List<Integer> list2 = Arrays.asList(1,2,3);
		System.out.println(list.size());
		for(String str : list){
			System.out.println(str);
		}
		//list.add("SQL"); 안됨
		//list.remove(0); //안됨
	}
}
