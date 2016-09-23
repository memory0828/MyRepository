package ch18.exam18;

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
			Reader rd = new InputStreamReader(is); //보조스트림달고
			BufferedReader br = new BufferedReader(rd); //거기에 또 보조스트림을 달고
			//클라이언트의 데이터를 행단위로 받음
			//그럼 클라이언트도 데이터를 보낼때 행단위로 보내야함
			String data = br.readLine(); 
			
			//클라이언트로 에코 보내기
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.print("[서버]"+data);
			ps.flush();
			
			//클라이언트의 연결을 끊음
			socket.close(); //해당 클라이언트와의 연결을 종료시키겠다
		}

		//프로그램이 끝날땐 반드시 서버 소켓이 닫아져야한당
		serverSocket.close(); //서버자체를 종료 시키겠다.
		System.out.println("==== [서버 종료]");
	}
}
