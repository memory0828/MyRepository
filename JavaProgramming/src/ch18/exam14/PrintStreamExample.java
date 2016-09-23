package ch18.exam14;

import java.io.*;
public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("data.txt");
		PrintStream ps = new PrintStream(fos);
		/*
		PrintStream이 바이트 처리를 하지만 바로 앞 예제에서 처럼 바이트처리한걸 바로 저장하는 방식이 나이라
		바이트 처리한걸 문자열로 바꿔써 그걸 저장하는 방식이당.
		그래서 파일열어보면 꺠지는 거 없이 잘 보인다.
		*/
		//문자로 바꿔서 문자로 그냥 전송(저장) 시킴
		ps.println(10);
		ps.println(true);
		ps.println(5.3);
		ps.println("java");
		ps.flush();
		
		ps.close();
		fos.close();
		
		//문자로 저장됐으니깐 굳이 FileInputStream으로 안받고 FileReader로 받아보자
		FileReader fr = new FileReader("data.txt"); //여기에는 .readLine()메소드가 없다 그래서
		BufferedReader br = new BufferedReader(fr); //이 버퍼 보조스트림을 활용
		//문자로 저장됐으니, 데이터를 걸러내는 처리과정!
		int v1 = Integer.parseInt(br.readLine());
		boolean v2 = Boolean.parseBoolean(br.readLine());
		double v3 = Double.parseDouble(br.readLine());
		String v4 = br.readLine();
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		br.close();
		fr.close();
	}
}
