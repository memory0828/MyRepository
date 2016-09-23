package ch18.exam13;

import java.io.*;
public class DataInputOutputStream {
	public static void main(String[] args) throws Exception {
		//DataOutputStream이용 저장하기
		FileOutputStream fos = new FileOutputStream("data.db");
		int v1 = 100;
		boolean v2 = true;
		double v3 = 5.3;
		String v4 = "java";
		DataOutputStream dos = new DataOutputStream(fos);
		//알아서 바이트로 변환해주는거
		dos.writeInt(v1); //int 4바이트
		dos.writeBoolean(v2); //boolean 1바이트
		dos.writeDouble(v3); //Double ? 바이트
		dos.writeUTF(v4); //UTF ? 바이트
		//저장될때 처리순서대로 차례대로 저장됨
		dos.flush();
		fos.close();
		
		//DataInputStream 이용 읽어들이기
		//저장된 파일을 열어보면 깨저있는데, 그거 정상적임. 텍스트에디터로는 볼수없음
		//그리거 파일에 저장된순서는 앞에서 이야기했듯이 위에서 처리한 순서대로
		FileInputStream fis = new FileInputStream("data.db");
		DataInputStream dis = new DataInputStream(fis);
		//저장된 순서대로 데이터도 가지고 와야함 안그러면 문제생김! 
		int v5 = dis.readInt();
		boolean v6 = dis.readBoolean();
		double v7 = dis.readDouble();
		String v8 = dis.readUTF();
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		System.out.println(v8);
		
		//결론
		//왜 이 보조스트림을 써야하냐?
		//바이트 변환의 편리와 이걸이용해서
		//네트워크 통신할때 문자 숫자 여러가지 섞어서 사용할떄도 많이 사용
	}
}
