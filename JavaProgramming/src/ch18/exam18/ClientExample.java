package ch18.exam18;

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
		PrintStream ps = new PrintStream(os);
		ps.println(data);
		ps.flush();
		
		//서버에서 본낸 데이터를 읽기
		InputStream is = socket.getInputStream();
		Reader rd = new InputStreamReader(is); //보조스트림달고
		BufferedReader br = new BufferedReader(rd); //거기에 또 보조스트림을 달고
		//서버에서 데이터를 행단위로 받기때문에 보낼때 행단위로 보내야함
		//이런거 고려없이 무조건 보내면 안됨
		String data2 = br.readLine(); 
		System.out.println("서버에서 온 에코 : " + data2);
		
		//서버와 연결을 끊음
		socket.close();
	}
}
