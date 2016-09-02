package ch11.exam03;

public class Example {
	public static void main(String[] args) {
		Date d1 = new Date();
		String d1Str = d1.toString();
		System.out.println(d1Str); //이제 2016-9-2이 나온다
		System.out.println(d1); //어 이것도 똑같이 2016-9-2이 나오네?
		//아 d1객체를 출력했더니만 toString()의 결과값이 나오는구나. 즉 toString()은 d1객체의 대표문자열이라는소리 
		//여튼 이렇게 toString()을 재정의해놓으니 의미 있는 문자열이 나온다
		//다시, 이렇게 의미있는 값을 나오게 하기위해서는 toString()을 재정의한다
		
		//이건 이렇게 응용할수있따.
		String re = d1 + " 맑음"; //원래대로면 다른 타입을 합치니깐 에러가 나는건데 d1의 대표문자열인 d1.toString()로 처리됨으로
		System.out.println(re); //여기서 결과가 2016-9-2 맑음 이렇게 출력된다.
	}
}
