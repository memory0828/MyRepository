package ch18.exam23.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<>();
	
	void startServer() {		
		//스레드풀 생성(최대  스레드 50개만  사용)
		executorService = Executors.newFixedThreadPool(50);
		
		//ServerSocket 생성(5001번 포트에서 사용)
		try{
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
		}catch(Exception e){
			//예외발생1 이미 포트 5001번이 사용중이면 예외 발생
			//소캣이 닫혀있지않으면 stopServer();을 실행
			if( !serverSocket.isClosed() ) { stopServer(); }
			return;
		}
		
		//클라이언트 연결 수락 작업 생성과 작업큐에 넣기
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				///////////////////////////////////////
				Platform.runLater(new Runnable() { 
					@Override
					public void run() { 
						//ui를 변경하는작업은 여기안에서 다해야한다
						displayText("서버 시작");
						btnStartStop.setText("stop");
					}
				});
				///////////////////////////////////////
				
				while(true){
					try {
						//클라이언트의 연결을 기다리고 수락하기
						Socket socket = serverSocket.accept();
						String message = "[연결 수락 :" + socket.getInetAddress().getHostAddress() + " : " + Thread.currentThread().getName() + "]";
						///////////////////////////////////////
						Platform.runLater(new Runnable() { 
							@Override
							public void run() { 
								displayText(message);
							}
						});	
						///////////////////////////////////////
						
						//통신 객체 Client 생성
						Client client = new Client(socket);
						
						//Client 관리
						connections.add(client);
						///////////////////////////////////////
						Platform.runLater(new Runnable() { 
							@Override
							public void run() { 
								displayText("[연결 개수 : " + connections.size() + "]" );
							}
						});
						///////////////////////////////////////
						
					} catch(Exception e){
						if( !serverSocket.isClosed() ){
							stopServer();
							break;
						}
						
					}
				}

			}		
		};
		
		//작업큐에 넣기
		executorService.submit(runnable);
	
	}
	
	void stopServer() {
		try{
			//서버 종료하는거니깐 클라이언트 소켓 모두 닫기
			//-> 이렇게쓰면 포문은 처음에 도는수가 결정되기때문에 문제생김
			/*			
 			for(Client client : connections){
				client.socket.close();
				//close했으니깐 더이상 살아있는거 아니니깐
				//리스트에서 죽은거 제거하기
				connections.remove(client);
			}*/
			//그래서 아래방법으로 처리해야함
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()){
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			//소켓 닫는것 - ★이거 안하면 form꺼도 열려있는상태라 스레드가 살아있음. ( 그래서 콘솔을 꺼야 재실행에 문제가 안생겼음)
			//               - 이걸응용하면 서버 ui 는 닫고 꺼도 소켓은 백그라운드로 살아있는 상태를 만들수있음
			if(serverSocket != null && !serverSocket.isClosed() ) {
					serverSocket.close();
			}	
			//스레드 깔끔하게 종료시키는거
			if(executorService != null && !executorService.isShutdown() ){
				executorService.shutdown();
			}
			
			///////////////////////////////////////
			Platform.runLater(new Runnable() { 
				@Override
				public void run() { 
					//ui를 변경하는작업은 여기안에서 다해야한다
					displayText("서버 멈춤");
					btnStartStop.setText("start");
				}
			});
			///////////////////////////////////////
			
		} catch (IOException e) {
			
		}
	}	
	
	class Client {
		Socket socket;
		
		Client(Socket socket){
			this.socket = socket;
			receive();
		}
		
		void receive(){
			//클라이언트의 데이터를 받는 작업 생성 및 큐에 넣기
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					try{
						while(true){
							InputStream is = socket.getInputStream();
							byte[] values = new byte[1024];
							int byteNum = is.read(values);
							/*이 is.read(values); 의 결과가
							 * 1. -1이 리턴되는 경우(클라이언트가 정상종료했을때)
							 * 2. 예외가 발생하는 경우 처리해줌(클라이언트가 비정상종료했을때)
							 * 이 두가지 경우를 고려해야함
							*/
							if(byteNum == -1) { throw new IOException(); } //예외떠넘기기

							String data = new String(values, 0, byteNum, "UTF-8");
							for(Client client : connections){
								client.send(data); //접속된 모든 클라이언트에게 메시지 전송
							}
						}
					}catch(Exception e ){
						try {
							//예외발생한(연결이 안된) 클라이언트 객체를 제거
							//   Client.this 중첩클래스에서~ ???? 지정하는법?(앞에서 봐야함)
							connections.remove(Client.this);
							String message = "[클라이언트 통신 안됨 :" + socket.getInetAddress().getHostAddress() + " : " + Thread.currentThread().getName() + "]";
							///////////////////////////////////////
							Platform.runLater(new Runnable() { 
								@Override
								public void run() { 
									displayText(message);
								}
							});	
							///////////////////////////////////////
							
							socket.close();
						} catch (IOException e1) { }
						
					}
				}				
			};
			executorService.submit(runnable); //작업 큐에 넣기
		}
		
		void send(String data){
			//클라이언트로 데이터를 보내는 작업 생성 및 작업큐에 넣기
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					try {
						OutputStream os = socket.getOutputStream();
						byte[] values = data.getBytes("UTF-8");
						os.write(values); //클라이언트가 없을 때 예외발생함
						os.flush();
				
					} catch(Exception e) {
						try {
							//예외발생한(연결이 안된) 클라이언트 객체를 제거
							//   Client.this 중첩클래스에서~ ???? 지정하는법?(앞에서 봐야함)
							connections.remove(Client.this);
							String message = "[클라이언트 통신 안됨 :" + socket.getInetAddress().getHostAddress() + " : " + Thread.currentThread().getName() + "]";
							///////////////////////////////////////
							Platform.runLater(new Runnable() { 
								@Override
								public void run() { 
									displayText(message);
								}
							});	
							///////////////////////////////////////
							
							socket.close();
						} catch (IOException e1) { }						
						
					}
					
				}
			};
			executorService.submit(runnable); //작업 큐에 넣기
		}
		
	}
	
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e->{
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")){
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event->stopServer());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
