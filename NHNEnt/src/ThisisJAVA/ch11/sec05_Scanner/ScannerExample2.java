package ThisisJAVA.ch11.sec05_Scanner;

import java.io.*;
import java.util.Scanner;
public class ScannerExample2 {
	public static void main(String[] args) throws Exception {
		//콘솔로부터 데이터를 받는 것
		InputStream is = new FileInputStream("src/ch18/exam08/data.txt");
		Scanner sc1 = new Scanner( is );

		/*
		//여기선 아무 문제가 없음
		int age = Integer.parseInt( sc1.nextLine() );
		String name = sc1.nextLine();		
		double height = Double.parseDouble( sc1.nextLine() );
		*/
		
		/*근데 이러헥하면 문제 발생함 왜?
		 * int age = sc1.nextInt(); 에서 읽어들일 때 엔터가 입력되지 않게 되고
		 * 그 입력되지 않은 엔터는 아래 명령어인
		 * String name = sc1.nextLine(); 를 실행하면서 엔터 입력으로 읽어 들어감
		 * 그렇게 처리되고 남은 
		 * double height = sc1.nextDouble(); 에서는 다음데이터인 홍길동을 읽어들이기 때문에 에러가 난다
		 * 그래서. 결국 결론은.
		 * 섞어 쓸거면 위에 처럼하던가 안할꺼면 그냥 다 nextLine() 처리해서 간단하게 하자 		  
		*/
		int age = sc1.nextInt();
		String name = sc1.nextLine();		
		double height = sc1.nextDouble();		

		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}
