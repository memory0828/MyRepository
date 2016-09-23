package ch18.exam19.server;

import java.io.*;
import java.net.*;
public class ServerExample {
	public static void main(String[] args) throws Exception {
		System.out.println("==== [서버 시작]");
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(5001); //5001포트 번호 지정
		
		for(int i=0; i<10; i++){
			Socket socket = serverSocket.accept();
			//클라이언트에서 보낸 데이터를 받기
			InputStream is = socket.getInputStream();
			byte[] receiveValues = new byte[1024];
			int byteNum = is.read(receiveValues);
			String data = new String(receiveValues, 0, byteNum, "UTF-8");
			
			//클라이언트로 에코 보내기
			OutputStream os = socket.getOutputStream();
			//인코딩된 바이트 얻어내기
			byte[] sendValues = data.getBytes(); //UT8로 강제인코딩
			os.write(sendValues);
			os.flush();
			
			//클라이언트의 연결을 끊음
			socket.close(); //해당 클라이언트와의 연결을 종료시키겠다
		}

		serverSocket.close(); //서버자체를 종료 시키겠다.
		System.out.println("==== [서버 종료]");
	}
}
