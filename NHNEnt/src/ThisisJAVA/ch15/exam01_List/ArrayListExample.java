package ThisisJAVA.ch15.exam01_List;
import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		//List 계열의 컬렉션 생성
		//List<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<>(); //위랑 동일함(생략하면 자동적으로 컴파일러가 알아서 ~)
			//위꺼기준으로 다 만들고나서 아래를 이렇게 바꿔치기해도 아래소스 수정불필요
			//왜? list인터페이스로 사용하니깐 다형성이 확보됨
			//List<String> list = new Vector<>(); 
			//List<String> list = new LinkedList<>();

		//객체 저장
		list.add("Java"); //0인덱스
		list.add("JDBC"); //1인덱스
		list.add("Servlet/JSP"); //2인덱스
		list.add(2, "Database");  //2인덱스에 삽입하고 기존 2인덱스->3인덱스로 한칸밀림
		list.add("iBatis"); //4인덱스
		
		//저장된 객체수 얻기
		int size = list.size();
		System.out.println("총 객체수 : " + size);
		
		//객체 찾기
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		//전체 객체를 일괄 처리
		//for 방식
		
		System.out.println("for방식 사용 >>>>");
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();

		System.out.println("향상된 for방식 사용 >>>>");
		//향상된 for 방식 : 여기에 사용할수있는 배열타입은 Iterable<E>라는 인터페이스를 구현한 객체만 사용가능하다		
		for(String str : list){
			System.out.println(str);
		}
		System.out.println();
		
		//객체 삭제
		list.remove(2); //인덱스 2가지워지고 뒤에서 앞으로 땡겨짐
		list.remove(2); //그 땡겨진게 있기때문에 또 2인덱스를 지울수가 있음
		list.remove("iBatis"); //위는 인덱스를 지우는거고 이건 "iBatis"라는 번지를 주고 지우는거다
		//list.remove(new String("iBatis")); //이것도 위랑 같은 결과(내부적으로 equals로 비교해서 지우는것)
		System.out.println("지우고 나서 >>>>");
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
	}
}
