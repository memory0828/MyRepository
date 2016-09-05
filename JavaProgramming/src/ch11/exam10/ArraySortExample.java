package ch11.exam10;

import java.util.Arrays;
public class ArraySortExample {
	public static void main(String[] args) {
		int[] scores = {99,97,98};
		//배열 올림차순 정렬1.
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));

		//클래스 배열 올림차순 정렬1.
		/*★이렇게 비교하는 내용 중요함
		 * 1. 이렇게 비교하려면 Member2 클래스에 implements Comparable 추가하고
		 * 2. compareTo 매소드 재정의하고 해당내용안에 코딩해야함
		 * 이 두가지 요소는 당연하다는듯이, 생각하고 해야함
		 */
		Member2[] m1 = {
				new Member2("홍길동", 10),
				new Member2("박동수", 1),
				new Member2("김민수", 5)
		};
		Arrays.sort(m1);
		System.out.println(Arrays.toString(m1));
	}
}

//같은파일임
class Member2 implements Comparable{ // implements Comparable 는 정렬할떄 compareTo를 사용해야함으로 추가  
	String name;
	int point;
	Member2(String name, int point){
		this.name = name;
		this.point = point;
	}
	@Override
	public int compareTo(Object o) {
		System.out.println("정렬");
		Member2 target = (Member2) o;
		
		//점수가 낮은사람이 앞으로 나오게 함
		//방법1
		return point - target.point;
		//방법2
		/*
		if( this.point == target.point ){
			return 0;
		}else if( this.point > target.point){
			return 1;
		}else{
			return -1;
		}*/
		
		//이름 순으로 나오게 함
		//방법1
		//return name.compareTo(target.name);
		//반환형이
		//음수 - Member2보다는 비교대상이 작은거
		//0 - 같은래밸
		//양수 - Member2보다는 비교대상이 크다는거
		//방법2
		//return target.name.compareTo(name); 이렇게하면 정렬순서가 다르게 나옴
		
	}	

	@Override
		public String toString() {
			return name;
		}
}