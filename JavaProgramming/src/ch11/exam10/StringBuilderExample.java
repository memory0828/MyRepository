package ch11.exam10;

public class StringBuilderExample {
	public static void main(String[] args) {
		//일반적으로 사용하는 방법
		String data = "a";
		data += "b";
		data += "c";
		System.out.println(data);
		
		//위를 StringBuilder로 사용하는방법( 결과는 동일함 )
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		System.out.println(sb);
		
		//일반적인 방법으로 "abc"있을때 중간에 추가해서 "azbc"로 만들려면 귀찮아지는데, StringBuilder로는 쉽다
		//즉, 원래있던 문자를 가공하고 싶으면 아래처럼 StringBuilder을 사용한다.
		String data2 = "abc";
		StringBuilder sb2 = new StringBuilder(data2);
		sb2.insert(1, "z");
		data2 = sb2.toString();
		System.out.println(data2);
	
	}
}
