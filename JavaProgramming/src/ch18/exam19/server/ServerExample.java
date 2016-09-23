package ch18.exam19.server;


//서버 프로그램
import java.io.*;
import java.net.*;
import java.util.*;
public class ServerExample {
	private static ServerSocket serverSocket = null;
	private static boolean stop = false;
	
	public static void main(String[] args){
		try {
			System.out.println("==== [서버 시작]");
			serverSocket = new ServerSocket(5001); //5001포트 번호 지정
		} catch (IOException e1) { 
			e1.printStackTrace();
		}
		
		//작업 스레드 라인 start
		Thread th = new Thread(){
			@Override
			public void run() { 
				try {
					waitAndAccept();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		th.start();
		//작업 스레드 라인 end
		
		//명령어 받는 기능
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("명령어 입력 : ");
			String cmd = scanner.nextLine();
			if(cmd.equals("stop")){
				stop = true; //작업 스레드 중지 시키기위한 스위치(=클라이언트와의 연결 수락을 중지)
				//서버자체를 종료 시키기
				try {
					serverSocket.close();
					System.out.println("==== [서버 종료]");
					System.exit(0); //서버 프로세스 종료
				} catch (IOException e) { }				
			}
		}
	}

	public static void waitAndAccept() throws Exception{
		while(!stop){
			Socket socket = serverSocket.accept();
			//.accept();를 실행하는 순간 블로킹(대기) 상태
			//언제 블로킹(대기)를 빠저나오나?
			//->클라이언트에서 연결 요청이 들어왔을때 블로킹에서 빠저나옴
			
			try{
				//클라이언트에서 보낸 데이터를 받기
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024];
				int byteNum = is.read(receiveValues);
				if ( byteNum != -1 ){
					String data = new String(receiveValues, 0, byteNum, "UTF-8");					
					//클라이언트로 에코 보내기
					OutputStream os = socket.getOutputStream();
					//인코딩된 바이트 얻어내기
					byte[] sendValues = data.getBytes("UTF-8"); //UT8로 강제인코딩
					os.write(sendValues);
					os.flush();
					
					//클라이언트의 연결을 끊음
					socket.close(); //해당 클라이언트와의 연결을 종료시키겠다
				}else{
					//정상 종료됐을경우
					System.out.println("[처리] 클라이언트가 정상 종료됨");
				}
			}catch(Exception e) {
				System.out.println();
				System.out.println("[ERROR] 클라이언트가 비정상 종료됨");
			}
		}//while의 끝
	}

} //클래스끝

