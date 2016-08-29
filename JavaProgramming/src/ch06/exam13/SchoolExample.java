package ch06.exam13;

public class SchoolExample {

	public static void main(String[] args) {
		School s1 = School.getInstance(); //이제 이렇게 객체참조위치를 얻고
		School s2 = School.getInstance(); //이제 이렇게 객체참조위치를 얻고
		System.out.println(s1 == s2);
		
		//private으로 선언했음에 이제 아래으로 사용못하게됨!!
		//School.singleton = null; 
		//School s3 = School.singleton;
		//그래서 애초에 논리오류가능성 없앰
	}
}
