package ch18.exam17;

import java.io.*;
import java.net.*;
public class ClientExample {
	public static void main(String[] args) throws Exception {
		//소켓 생성
		Socket socket = new Socket();
		
		//연결 요청하기
		SocketAddress sa = new InetSocketAddress("192.168.0.17", 5001);
		//SocketAddress sa = new InetSocketAddress(5001);
		socket.connect(sa);
		System.out.println("서버와 연결이 됨");
		
		//서버와 연결을 끊음
		socket.close();
	}
}
