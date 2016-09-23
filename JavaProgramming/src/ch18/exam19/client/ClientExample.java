package ch18.exam19.client;

import java.io.*;
import java.net.*;
import java.util.*;
public class ClientExample {
	public static void main(String[] args) throws Exception {
		//소켓 생성
		Socket socket = new Socket();
		
		//연결 요청하기
		SocketAddress sa = new InetSocketAddress("192.168.0.17", 5001);
		//SocketAddress sa = new InetSocketAddress(5001);
		socket.connect(sa);
		System.out.println("[서버와 연결이 됨]");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("보낼것 : ");
		String data = scan.nextLine();
		
		//서버로 데이터를 보내기
		OutputStream os = socket.getOutputStream();
		byte[] sendValues = data.getBytes(); //UT8로 강제인코딩
		os.write(sendValues);
		os.flush();
		
		//서버에서 본낸 데이터를 읽기
		InputStream is = socket.getInputStream();
		byte[] receiveValues = new byte[1024];
		int byteNum = is.read(receiveValues);
		data = new String(receiveValues, 0, byteNum, "UTF-8");
		System.out.println("서버에서 온 에코 : " + data);
		
		//서버와 연결을 끊음
		socket.close();
	}
}
