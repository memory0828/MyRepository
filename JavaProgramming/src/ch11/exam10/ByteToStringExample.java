package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		/*
		 * 파일의 내용을 읽거나 네트워크를 통해 받은 데이터는 보통 byte[]배열이므로 이것을 문자열로
		 * 변환하기 위해 사용
		byte[] 배열을 문자열로 변환하는 생성자
		가. 배열 전체를 String 객체생성
			String str = new String(byte[] bytes);
		나. 지정한 문자셋으로 디코딩
			String str = Strig(byte[] bytes, String charsetName);		
		다. 배열의 offset 인덱스 위치부터 length 개 만큼 String 객체 생성
			String str = String(byte[] bytes, int offset, int length);
		라. 지정한 문자셋으로 디코딩
			String str = new String(byte[] bytes, int offset, int length, String charsetName);
		*/		
		
		//바이트 배열을 문자로 바꾸기		
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97  }; //문자코드들(아스키)
		String str1 = new String(bytes); //문자코드들이 변환되서 문자가 만들어진
		System.out.println(str1);
		String str2 = new String(bytes, 6, 4); // 6은 인덱스의값, 4는 길이(갯수)
		System.out.println(str2);
		
		System.out.println("====================================");
		//------------------------------------------------------
		// 기본문자셋으로 사용
		//------------------------------------------------------
		String str3 = "홍길동"; //한글은 아스키값으로 적용할수없지.
		//(인코딩) 자바의기본적인 문자셋로 사용해서 홍길동 문자를 한문자를 2바이트로 표현해서 바이트배열에 저장하고(6바이트)
		byte[] strBytes3 = str3.getBytes();
		//(디코딩) 그 바이트배열을 다시 문자로 복원
		String str4 = new String(strBytes3);
		System.out.println(str4); //결과 출력
		
		System.out.println("====================================");
		//------------------------------------------------------
		// 문자셋을 지정하는 방법-1
		//------------------------------------------------------
		String str5 = "홍길동";
		//인코딩 : 어떤문자를 바이트배열로 만드는작업
		//- UTF-8문자셋으로 홍길동 문자를 한문자를 3바이트로 표현해서 바이트배열에 저장하고(9바이트)
		byte[] strBytes5 = str5.getBytes("UTF-8"); 
		//디코딩 : 바이트배열을 다시 문자열로 만드는작업
		//- 여기서 예외발생해서 ""안에 잘못된 문자셋이들어올수있음에.. 그래서 위에 throw에 추가함
		//- String str6 = new String(strBytes5); //그 바이트배열을 다시 문자로 복원 : 이거는 글씨가깨짐 그래서
		//- 그 바이트배열을 다시 문자로 복원 -> 이거는 잘됨, UTF-8 문자셋으로 다시 디코딩했으니
		String str6 = new String(strBytes5, "UTF-8"); 
		System.out.println(str6); //결과 출력

		System.out.println("===================================="); 
		//------------------------------------------------------
		// 문자셋을 지정하는 방법-2 (범위지정해서 결과출력)
		//------------------------------------------------------
		String str20 = "ab홍길동";
		byte[] strBytes20 = str20.getBytes(); 
		String str21 = new String(strBytes20); 
		System.out.println(str21); //ab홍길동 출력됨
		String str22 = new String(strBytes20, 2, 9); //2, 9이됨 : 문자셋마다 숫자가 달라진다.
		System.out.println(str22); //홍길동 출력됨
		
		String str7 = "ab홍길동";
		byte[] strBytes7 = str7.getBytes("EUC-KR"); 
		String str8 = new String(strBytes7, "EUC-KR"); 
		System.out.println(str8); //ab홍길동 출력됨
		String str9 = new String(strBytes7, 2, 6,"EUC-KR"); //2, 6이됨 : 문자셋마다 숫자가 달라진다.
		System.out.println(str9); //홍길동 출력됨

		String str10 = "ab홍길동";
		byte[] strBytes10 = str10.getBytes("UTF-8"); 
		String str11 = new String(strBytes10, "UTF-8"); 
		System.out.println(str11); //ab홍길동 출력됨
		String str12 = new String(strBytes10, 2, 9,"UTF-8"); //2, 9이됨 : 문자셋마다 숫자가 달라진다.
		System.out.println(str12); //홍길동 출력됨
		
		// String str = new String(byte[] bytes, int offset, int length, String charsetName);
		// 에서 offset, length는 문자셋에 따라 다르게 지정해야한다. 어떤건 한문자에 2 어떤건 3식임
		// 즉, 생정자통해 문자를 저장할때 문자셋이 중요하다 
		// 왜 이런게 중요하냐? 네트워크를 통해 흘러가는 데이터는 전부다 byte임으로
		// 서버<->클라이언트에서 데이터를 전송할때 byte로 바꿀수잇어야하고 그걸 양쪽에서
		// 문자셋을 통일해서 인코딩-디코딩을 해야함으로
		//★결론 인코팅할때 사용했던 문자셋과 디코딩할때 사용하는 문자셋은 같아야한다.
	}
}
