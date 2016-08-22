package ch05.exam01;

public class ValueReferenceCompare {

	public static void main(String[] args) {

/*		int v1 = 100;
		int v2 = 100;
						
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);
		*/
				//참조 비교(객체 비교)
		String r1 = new String("자바"); //String("자바")라는 새로운 객체의 번지가 저장됨
		String r2 = new String("자바"); //String("자바")라는 새로운 객체의 번지가 저장됨
		System.out.println(r1 == r2); // 그래서 같지 않음
		System.out.println(r1 != r2);
		
		String r3 = "자바"; //어딘가에 있는 "자바"라는 객체의 번지가 저장됨
		String r4 = "자바"; //어딘가에 있는 "자바"라는 객체의 번지가 저장됨
		//즉 하나의 번지를 r3 r4가 참조함
		//String만 예외적으로 new없이 만들수있다
		System.out.println(r3 == r4);  //그래서 같음
		System.out.println(r3 != r4);
		//r3가 참조하는 객체와 r4가 참조하는 객체는 같으냐 다르냐
		
		//null은 참조변수만 지정가능
		//int x = null; 이건 불가능
		String s = null; //이건 가능함
		int[] t = null; //이건 가능함
		//s.setText <- null이있으면 객체참조 연산자 이걸 사용할수없다

	}

}
