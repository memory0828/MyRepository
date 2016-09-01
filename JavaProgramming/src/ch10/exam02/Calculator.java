package ch10.exam02;

//throws 예외떠넘기기
public class Calculator {
	public static int sum(String x, String y) throws NumberFormatException{ 
		//throws 뒤에 발생가능한 예외를 미리 알려줌, 그럼 이것을 호출하는 곳에서 이걸 보고 예외처리를 한다
		int v1 = Integer.parseInt(x);
		int v2 = Integer.parseInt(y);
		int result = v1 + v2;
		
		return result;
	}
}
