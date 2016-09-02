package ch11.exam04;

public class ExitExample {
	public static void main(String[] args) {
		System.setSecurityManager( new SecurityManager() {
		@Override
			public void checkExit(int status) {
				if(status != 5){
					//5가아니면 계속 예외를 발생시켜서 예외처리에서 실행해서 계속 실행하게끔 만들어주는거다
					throw new SecurityException(); 
				}
				System.out.println("나죽음");
			}	
		});
		
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				System.exit(i); //완전히 프로그램을 종료하라
				//즉 종료상태 번호이며, 이 종로상태 번호를 통해 프로그램이 종료되고 아니고를 결정할수있고
				//그 종료는 SecurityManager에서 판단하고
				//기본적으로 SecurityManager는 종료상태 번호를 조사하지 않고 어떠한 값을 넣더라도 프로세스 종료가 된다.
				//그래서 만약에 5라는 값을 넣어야만 종료하게끔 하겠다면 이 예제처럼 만들어서
				//5가 아닐경우는 예외를 발생(=프로세스가 정상종료를 안했다는 뜻으로 만들고) 시켜서, try catch로 처리하게하고
				//만약 5일경우에는 예외가 안생기니깐 프로세스가 종료처리된다.
				//이건 주로 서버프로그램에서 많이 사용되는 방법으로
				//누군가 악으성이 있게 종료명령어를 발생시켰을때, 관리자가 미리 관리자만 알수있는 종료상태번호를넣어서,
				//이 종료상태번호를 알아야만 프로세스가 종료되도록 만드는데 활용된다.
			}catch(SecurityException e){}
		}
	}
}



