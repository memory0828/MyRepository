package ThisisJAVA.ch15.exam03_Map;

import java.util.*;
public class HashMapExample {
	public static void main(String[] args) {
		//Map 계열 컬렉션 생성
		Map<String, Integer> mp = new HashMap<>();
		//Map<String, Integer> mp = new Hashtable<>(); //이렇게해도 아래서 작동다됨		

		//엔트리 추가
		mp.put("홍길동", 85);
		mp.put("추가을", 85);
		mp.put("홍길동", 95); //키값이 등등객체라 앞에있는 홍길동에 이걸 덮어씌어지면서 85는 사라지고 95가 됨
		mp.put("감자바", 81);		
		System.out.println("전체 사이즈 : " + mp.size());
		
		//객체(값) 얻기
		int score = mp.get("홍길동");
		System.out.println(score); //덮어 씌어진거 확인함
		
		//모든 엔트리 일괄처리
		Set<Map.Entry<String, Integer>> st1 = mp.entrySet();
		for(Map.Entry<String, Integer> mpe : st1){
			System.out.println(mpe.getKey() + " / " + mpe.getValue());
		}
		System.out.println();
		//다른 방식
		Set<String> st2 = mp.keySet();
		for(String key : st2){
			System.out.println(mp.get(key));
		}
		
		//객체 삭제
		mp.remove("홍길동"); //키가 홍길동인 엔트리 자체가 삭제됨
		
	}
}
