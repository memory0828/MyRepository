package ch11.exam10;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		//contains : 이 문자열에 어떤 단어가 포함되어있는지 조사하고싶다
		boolean result1 = subject.contains("자바");
		if(result1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
		
		
		//indexOf  : 찾으면( - 주어진문자열의 첫번째 인덱스 위치 리턴), ★못찾으면( -1 리턴 )
		int location = subject.indexOf("자바");
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
		//indexOf는 이렇게도 많이 쓰지만, 문자열을 잘라낼때 다른거랑 조합해서(시작인덱스를 구할때) 많이 사용함
		
		
		//substring 어디서부터 어디까지 잘라낼것인지 사용
		/*String	substring(int beginIndex) : 시작인덱스부터 끝까지
		 *String	substring(int beginIndex, int endIndex) : 시작인덱스부터, 끝인덱스-1까지
		*/
		//예1)
		String token1 = subject.substring(0,2); //0 시작인덱스부터, 끝인덱스(표현할) 이전까지를 짤라내라
		System.out.println(token1);
		//예2)
		int startIndecx = subject.indexOf("자바"); //시작인덱스
		int endIndecx =startIndecx + 2; //끝 인덱스
		//시작인덱스는 0~ 이지만
		//끝 인덱스(시작부터~문자열길이아님)는 끝인덱스-1까지 짤라내라를 의미함
		String token2 = subject.substring(subject.indexOf("자바"), endIndecx);
		System.out.println(token2);
		//예3)
		startIndecx = subject.indexOf("프로그래밍");
		endIndecx = startIndecx + "프로그래밍".length(); // 이 "프로그래밍".length(); 는 응용이다ㅎ
		//시작인덱스는 0~ 이지만
		//끝 인덱스(시작부터~문자열길이아님)는 끝인덱스-1까지 짤라내라를 의미함
		String token3 = subject.substring( startIndecx, endIndecx);
		System.out.println(token3);		
		//예4)
		String token4 = subject.substring( startIndecx ); //시작인덱스부터 그냥 끝까지
		System.out.println(token4);
	}
}
 