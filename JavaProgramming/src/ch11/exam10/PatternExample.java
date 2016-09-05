package ch11.exam10;

import java.util.regex.Pattern;
public class PatternExample {
	public static void main(String[] args) {
		String tel1 = "010-123-1234";
		String tel2 = "013-123-1234";
		String tel3 = "010-1234-1234";
		String tel4 = "010-123-123";
		
		String regExp = "(011|010)-\\d{3,4}-\\d{4}";
		/*
		 * 정규식표현식 내용 해석
		 *  (011|010) : 010 아님 011 둘중하나 와야하고
		 *  -
		 *  \\d : 숫자여야하고. 
		 *  {3,4} : 숫자가 3개 아님 4개가 되야한다.
		 *  -
		 *  \\d : 숫자여야하고
		 *  {4} : 숫자는 4개만 되야한다.
		 */
		System.out.println( Pattern.matches(regExp, tel1 ) ); //true
		System.out.println( Pattern.matches(regExp, tel2 ) ); //false
		System.out.println( Pattern.matches(regExp, tel3 ) ); //true
		System.out.println( Pattern.matches(regExp, tel4 ) ); //false
		
		String email1 = "hong@naver.com";
		String email2 = "hongnaver.com";
		String email3 = "hong@navercom";
		String regExp2 = "\\w+@\\w+\\.\\w+";
		System.out.println( Pattern.matches(regExp2, email1 ) ); //true
		System.out.println( Pattern.matches(regExp2, email2 ) ); //false
		System.out.println( Pattern.matches(regExp2, email3 ) ); //false
		
		//인터넷에서 이메일정규식 같은 단어로 검색해서 가져다 쓰면됨
	}
}