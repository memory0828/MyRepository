package ch18.exam08;

import java.util.Scanner;
public class ScannerExample {
	public static void main(String[] args) {
		//콘솔로부터 데이터를 받는 것
		Scanner sc1 = new Scanner( System.in );

		System.out.println("나이 : ");
		int age = sc1.nextInt();
		// 이놈은 엔터처도 케리지리턴과 라인피드 까지는 읽어들이지 않고, 그냥 내버려둠.
		
		System.out.println("이름 : ");
		String name = sc1.nextLine();
		//콘솔에서 행전체(nextLine)를 입력받아라!
		//이놈은 엔터치면 케리지리턴과 라인피드 까지는 읽어들이고, 데이터를 저장할때는 엔터키읽은건 버리고 저장함
		//즉, 이 nextLine는 케리지리턴 라인피드까지 읽는 역할을 하기 때문에 앞에 nextInt에서 입력후 엔터키를 입력하게되면		
		//그 엔터가 여기까지 들어와서 이 nextLine에서 그냥 엔터가 처진걸로 처리가 됨
		//그래서 이소스처럼 섞어 쓰면 오류나고 정신건강에 안좋으니 그냥 다 nextLine으로 처리해서 넘겨받은데이터를 변형해서
		//사용하는게 좋다

		//1. 입력이 들오기전까지 대기함
		//2. 입력이 들어와서 엔터가 들어오면 대기상태가 풀리면서 입력된것을 String로 바꿔서 리턴함		
		System.out.println("키 : ");
		double height = sc1.nextDouble();		
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
}
