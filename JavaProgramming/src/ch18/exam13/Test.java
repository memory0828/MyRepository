package ch18.exam13;

import java.io.*;
public class Test {
	public static void main(String[] args) throws Exception {
		// 아래와 같이 단순하게 10을 가지고 저장하고 읽어들이는게 귀찮은 작업임
		// 내가 10을 처리할때 아래같은 과정을 처리해야함으로 저장할때 도 귀찮고, 읽어드릴 떄도 귀찮고~
		// 그래서 보조스트림(DataInputStream과 DataOutputStream)
		// 을 사용하면 보조스트림자체에 내부적으로 쉬프트 연산이 있어서 간편하게 처리가 가능
		// 즉, 프로그램에서 어떤 기본타입의 값을 저장(보내거나)하거나 받고싶을떄 사용하는것
		// 이 아래 예제는 수업시간에 다뤘는데, 중간에 딴짓해서 타이핑 잘못침 그래서 뭔가 작동안함
		// 그냥 이런식의 복잡한 ㅋ 처리과정이 있었다 는 정도로 이해하장
		
		int value = 10;
		//저장 
		//바이트로 변환해서 저장해야함
		FileOutputStream fos = new FileOutputStream("aaa.data"); 
		fos.write(value);
		value = value >> 8; //쉬프트 연산
		fos.write(value);
		value = value >> 8; //쉬프트 연산
		fos.write(value);
		value = value >> 8; //쉬프트 연산
		
		//읽어들임
		//바이트를 읽어서 쉬프트해야함..... ㄸ
		FileInputStream fis = new FileInputStream("aaa.data");
		value = fis.read();
		value = value >> 24;
		System.out.println("읽어들임 : " + value);
	}
}
