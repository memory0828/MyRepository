package ch18.exam17;

import java.io.*;
import java.net.*;
public class ServerExample {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(5001); //5001포트 번호 지정
		//클라이언트의 연결을 수락하고 통신용 socket을 생성
		for(int i=0; i<10; i++){
			System.out.println("[클라이언트의 연결을 기다림]");
			Socket socket = serverSocket.accept(); //.accept(); 클라이언트가 연결될때까지 대기하다, 연결되면 Socket을 반환
			
			String clientIP = socket.getInetAddress().getHostAddress();
			System.out.println("[클라이언트의 " +clientIP+ " 연결을 수락함]");
			
			//클라이언트의 연결을 끊음
			socket.close(); //해당 클라이언트와의 연결을 종료시키겠다
		}

		//프로그램이 끝날땐 반드시 서버 소켓이 닫아져야한당
		serverSocket.close(); //서버자체를 종료 시키겠다.
	}
}
