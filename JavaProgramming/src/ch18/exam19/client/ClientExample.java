package ch18.exam19.client;

//클라이언트 프로그램
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientExample {
	private static Socket socket = null;
	private static boolean stop = false;	
	
	public static void main(String[] args) {
		try{
			//기능 - 서버 연결 요청하기
			//SocketAddress sa = new InetSocketAddress("192.168.0.17", 5001);
			SocketAddress sa = new InetSocketAddress(5001);
			socket = new Socket(); //소켓 생성		
			socket.connect(sa);
			System.out.println("[처리] 서버 응답함"); //무응답시 예외처리함

			Thread th = new Thread(){
				@Override
				public void run() {
						sendAndReceive();
				}

			};
			th.start();
			//======================
			
		}catch(Exception e) {
			//서버 자체에 응답이 없을경우
			System.out.println("[ERROR] 서버 무응답 중");
		}
	}
	
	public static void sendAndReceive(){
		while( !stop ){
			//기능 - 보낼 데이터 받기 
			Scanner scan = new Scanner(System.in);
			System.out.print("명령어[send or stop] : ");
			String data = scan.nextLine();
			if(data.equals("send")){			
				//기능 - 연결이 된 이후에 에러가 났을 경우 처리 - 1(안좋은방법)
				/*		
				if(socket.isConnected() ){
					OutputStream os = socket.getOutputStream();
					byte[] sendValues = data.getBytes("UTF-8"); //UT8로 강제인코딩					
					os.write(sendValues);
					os.flush();
				}else{
					System.out.println("서버와 연결이 되지 않습니다.");
				}
				//근데 이걸로 하면 에러처리가 잘 안된당
				*/

				//기능 - 연결이 된 이후에 에러가 났을 경우 처리 - 2( 좋은 방식 )		
				try{
					//기능 - 서버로 데이터를 보내기
					OutputStream os = socket.getOutputStream();
					byte[] sendValues = data.getBytes("UTF-8"); //UT8로 강제인코딩			
					os.write(sendValues);
					os.flush();

					//기능 - 서버에서 본낸 데이터를 읽기
					InputStream is = socket.getInputStream();
					byte[] receiveValues = new byte[1024];
					int byteNum = is.read(receiveValues);
					data = new String(receiveValues, 0, byteNum, "UTF-8");
					System.out.println("서버에서 온 에코 : " + data);
					
				}catch(Exception e) {
					System.out.println("[ERROR] 서버와 연결이 끊어짐");			
				}
			}else if(data.equals("stop")){
				//클라이언트 정상 종료 시키기
				stop = true; //명령어기능 중지시킴
				clientStop(); //서버와의 접속 끊음
			}
		}
	}
		
	public static void clientStop(){		
		//기능 - 서버와 연결을 끊음 처리
		try{
			socket.close();
			System.out.println("[처리] 서버와 연결 끊음");

		}catch(Exception e) {
			System.out.println("[ERROR] 서버에 문제가 있어서 끊어짐");
		}

	
	}
}
