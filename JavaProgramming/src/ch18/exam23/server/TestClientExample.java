package ch18.exam23.server;

//TEST 클라이언트 프로그램
import java.io.*;
import java.net.*;
import java.util.*;

public class TestClientExample {
	private static Socket socket;
	private static boolean stop;
	
	public static void main(String[] args) {
		//소켓 생성
		socket = new Socket();
	
		try {
			//연결 요청하기
			SocketAddress sa = new InetSocketAddress(5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
			
			//[생각] 쓰레드 생성 및 재정의
			Thread thread = new Thread() {
				@Override
				public void run() {
					sendAndReceive();
				}
			};
			thread.start();
		} catch (IOException e) {
			System.out.println("[서버 연결이 안됨]");
		}
	}
	
	private static void sendAndReceive() {
		try {
			while(!stop) {
				//보낼 데이터를 키보드로부터 읽기
				Scanner scanner = new Scanner(System.in);
				System.out.print("명령어 입력[send or stop]: ");
				String data = scanner.nextLine();
				if(data.equals("send")) {
					System.out.print("보낼 데이터: ");
					data = scanner.nextLine();
					
					//서버로 데이터를 보내기
					OutputStream os = socket.getOutputStream();
					byte[] sendValues = data.getBytes("UTF-8");
					os.write(sendValues);
					os.flush();
				
					//서버에서 보낸 데이터를 읽기
					InputStream is = socket.getInputStream();
					byte[] receiveValues = new byte[1024];
					int byteNum = is.read(receiveValues);
					data = new String(receiveValues, 0, byteNum, "UTF-8");
					System.out.println(data);							
				} else if(data.equals("stop")) {
					clientStop();
				}
			}
		} catch(Exception e) {
			System.out.println("[서버 연결이 끊어졌음]");
		}
	}
	
	private static void clientStop() {
		//클라이언트의 정상 종료 시키기
		try {
			stop = true;   	//보내고 받기 중지
			socket.close();	//클라이언트의 정상 종료
			System.out.println("[클라이언트 종료]");
		} catch(Exception e) {}
	}
}

