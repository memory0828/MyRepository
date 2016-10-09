package ThisisJAVA.ch15.exam02_Set;

import java.util.*;
public class HashSet01Example {
	public static void main(String[] args) {
		//Set 계열 컬렉션 생성
		Set<String> st = new HashSet<String>();

		//객체 저장
		st.add("Servet/JSP");				
		st.add("Java");
		st.add("JDBC");
		st.add("Java"); //앞의 Java와 똑같기 때문에 중복저장허용안됨! 그래서 저장안됨
		st.add("iBATIS");		
		System.out.println("전체 : " + st.size());
		
		//객체를 일괄 처리하기
		Iterator<String> it = st.iterator();
		//방법1 while는 지울때 사용해도됨
		System.out.println("방법1 while");
		while(it.hasNext()){
			String str = it.next(); //들어간 순서대로 가져온다? 아니다. st에 저장될때부터 내부적으로 순서는 없다. 
			if(str.equals("JDBC")){
				it.remove();
			}
			System.out.println(str);
		}
		System.out.println();
		//방법2 향상된 for문은 지울때 사용안됨(못함)
		System.out.println("방법2 for");
		for(String str : st){ //for문이 실행될 때 이미 몇 번돌지 결정하기 때문에
			System.out.println(str);
		}
	}
}
