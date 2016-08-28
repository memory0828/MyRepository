package ch06.homework;

import java.util.Scanner;

public class BoardMain {
	/* ==============================
	 * 16 08 22 과제 - 게시판 만들기
	 * 제작자 : 유호선
	 * ==============================*/
	
	public static void main(String[] args)  throws Exception{
		//@@@@@@@@@@@@@@@@@@@@@@
		//@  main 메소드
		//@@@@@@@@@@@@@@@@@@@@@@
		Scanner scan = new Scanner(System.in);
		int intDBIndexCount = 1;	 				//데이터 세이브 카운터
		Board[] BoardDB = new Board[100]; 	//데이터 저장
		
		//처음 목록 출력
		BoardMain.PrintList(BoardDB, intDBIndexCount);
		
		while(true){
			System.out.println("=====================================================================================");
			System.out.println("\t| 1.목록 | 2.글쓰기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6종료 |");
			System.out.println("\t\t▶ 데이터는 낭비공간없이 null 대상 저장 ◀");			
			System.out.println("\t\t▶ 목록은 [번호]기준 오름차순 자동 정렬 ◀");
			System.out.println("=====================================================================================");
			System.out.print("\t● 선택 : ");
			String strMenuChoice = scan.nextLine();
			if ( strMenuChoice.equals("1") ){
				//===========
				//1. 목록
				//===========
				BoardMain.PrintList(BoardDB, intDBIndexCount);
			}else if ( strMenuChoice.equals("2") ){
				//===========
				//2. 글쓰기
				//===========
				System.out.println("");
				System.out.println("\t----- [글쓰기 기능]");
				for(int i=0; i<BoardDB.length; i++){
					if(BoardDB[i] == null){
						System.out.print("\t● 제목 : ");
						String strSubject = scan.nextLine();
						System.out.print("\t● 글쓴이 : ");
						String strMaker = scan.nextLine();
						System.out.print("\t● 내용 : ");
						String strContent = scan.nextLine();
						Board BoardTemp = new Board( intDBIndexCount, strSubject, strMaker, strContent ); 
						BoardDB[i] = BoardTemp; 
						//@저장 카운터 증가
						intDBIndexCount++; 
						break;
					}
				}
				
			}else if ( strMenuChoice.equals("3") ){
				//===========
				//3. 상세보기
				//===========
				System.out.println("");
				System.out.println("\t----- [상세보기 기능]");
				System.out.print("\t● 조회할 게시물의 [번호] 입력 : ");
				String strIndex = scan.nextLine();
				boolean sw = false;
				for(int i=0; i<BoardDB.length; i++){
					if(BoardDB[i] != null){
						if(Integer.parseInt(strIndex) == BoardDB[i].no ){
							//해당 게시글이 존재할경우 출력
							//@조회했으니 카운터 +1
							BoardDB[i].plusCnt(); 
							//@상세보기 출력
							System.out.println("\t----------------------------------------------------------------------------");
							System.out.println( "\t■제목 : " + BoardDB[i].subject  );
							System.out.print( "\t■번호 : " + BoardDB[i].no  );
							System.out.print( "\t ■글쓴이 : " + BoardDB[i].writer  );
							System.out.print( "\t ■조회수 : " + BoardDB[i].cnt  );
							System.out.println();
							System.out.println( "\t■내용 : " + BoardDB[i].content  );
							System.out.println("\t----------------------------------------------------------------------------");														
							sw = true; 
							break;
						};
					}
				}
				//해당 게시글이 존재안할경우 출력
				if(sw==false) System.out.println("\t□ Error : 입력한 게시글은 존재하지 않음");
				
			}else if ( strMenuChoice.equals("4") ){
				//===========
				//4. 수정하기
				//===========
				System.out.println("");
				System.out.println("\t----- [수정하기 기능]");
				System.out.print("\t● 수정할 게시물의 [번호] 입력 : ");
				String strIndex = scan.nextLine();
				boolean sw = false;
				for(int i=0; i<BoardDB.length; i++){
					if(BoardDB[i] != null){
						if(Integer.parseInt(strIndex) == BoardDB[i].no ){
							//해당 게시글이 존재할경우 출력
							System.out.print("\t● 제목 : ");
							String strSubject = scan.nextLine();
							System.out.print("\t● 글쓴이 : ");
							String strMaker = scan.nextLine();
							System.out.print("\t● 내용 : ");
							String strContent = scan.nextLine();
							BoardDB[i].subject = strSubject;//제목 
							BoardDB[i].writer = strMaker;//작성자
							BoardDB[i].content = strContent; //내용							
							sw = true; 
							break;
						};
					}
				}
				//해당 게시글이 존재안할경우 출력
				if(sw==false) System.out.println("\t□ Error : 지정된 게시글은 존재하지 않음");				
				
			}else if ( strMenuChoice.equals("5") ){
				//===========
				//5. 삭제하기
				//===========
				System.out.println("");
				System.out.println("\t----- [삭제하기 기능]");
				System.out.print("\t● 삭제할 게시물의 [번호] 입력 : ");
				String strIndex = scan.nextLine();
				boolean sw = false;
				for(int i=0; i<BoardDB.length; i++){
					if(BoardDB[i] != null){
						if(Integer.parseInt(strIndex) == BoardDB[i].no ){
							//해당 게시글이 존재할경우 출력
							 System.out.print("\t● 정말 삭제하시겠습니까?(y or n) : ");
							 if(scan.nextLine().equals("y")){
								 BoardDB[i] = null;
								 System.out.println("\t● 삭제 OK! ");			 
							 }else{
								 System.out.println("\t● 삭제 Cancel!");
							 }
							sw = true; 
							break;
						};
					}
				}
				//해당 게시글이 존재안할경우 출력
				if(sw==false) System.out.println("\t□ Error : 지정된 게시글은 존재하지 않음");
				
			}else if ( strMenuChoice.equals("6") ){
				//===========
				//6. 종료
				//===========
				System.out.println("\t-----[프로그램 종료]");
				break;
			}else{
				System.out.println("\t□ Error : 1~6을 입력하세요");
			} 
			
		}
	}//main 종료

	
	public static void PrintList(Board[] argsBoardTarget, int argsIntDBIndexCount) {
		//@@@@@@@@@@@@@@@@@@@@@@
		//@  PrintList메소드 : 목록 출력
		//@@@@@@@@@@@@@@@@@@@@@@

		System.out.println("");
		System.out.println("");
		System.out.println("\t\t\t\t\t간이 게시판");
		System.out.println("=====================================================================================");
		System.out.println("[번호]\t\t[제목]\t\t\t\t\t[글쓴이]\t[조회수]");
		System.out.println("=====================================================================================");

		//번호순 오름차순 목록 표현(정렬기능 아님)
		int intCnt = 0; //출력된 목록 카운터
		for(int intPrintTaregetNo=argsIntDBIndexCount; 1<=intPrintTaregetNo; intPrintTaregetNo--){
			for(Board arr : argsBoardTarget){
				if(arr != null && intPrintTaregetNo == arr.no ) {
					System.out.print(" " + arr.no ); //번호
					System.out.print("\t\t");
					System.out.print(arr.subject ); //제목
					System.out.print("\t\t\t");
					System.out.print(arr.writer ); //글쓴이
					System.out.print("\t\t");
					System.out.println(arr.cnt ); //조회수
					intCnt++;
				}
			}
		}
		//출력된 목록이 하나도 없을 경우
		if(intCnt == 0){
			System.out.println("");
			System.out.println("\t- 저장된 데이터가 하나도 없음 -");
			System.out.println("");
		}
	}
}
