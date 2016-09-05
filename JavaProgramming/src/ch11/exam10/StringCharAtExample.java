package ch11.exam10;

public class StringCharAtExample {
	public static void main(String[] args) {
		//    인덱스 : 01234567
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7); //지정된 인덱스의 한문자를 반환
		switch (sex) {
			case '1':
			case '3':
				System.out.println("남자 입니다.");
				break;
			case '2':
			case '4':
				System.out.println("여자 입니다.");
				break;
		}
	}
}


