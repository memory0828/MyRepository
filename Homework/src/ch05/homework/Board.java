package ch05.homework;

import java.util.Scanner;

public class Board {
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
		String[][] strDB = new String[100][]; 	//데이터 저장
		
		int[][] intA = { {1,2,3},{4,5,6} };
		/*
		 * StrDB[0] = "번호" - index 코드
		 * StrDB[1] = "제목"
		 * StrDB[2] = "글쓴이"
		 * StrDB[3] = "조회수" 
		 * StrDB[4] = "내용"
		 */
		
		//처음 목록 출력
		Board.PrintList(strDB, intDBIndexCount);
		
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
				Board.PrintList(strDB, intDBIndexCount);
			}else if ( strMenuChoice.equals("2") ){
				//===========
				//2. 글쓰기
				//===========
				System.out.println("");
				System.out.println("\t----- [글쓰기 기능]");
				for(int i=0; i<strDB.length; i++){
					if(strDB[i] == null){
						System.out.print("\t● 제목 : ");
						String strSubject = scan.nextLine();
						System.out.print("\t● 글쓴이 : ");
						String strMaker = scan.nextLine();
						System.out.print("\t● 내용 : ");
						String strContent = scan.nextLine();
						String[] strTemp = {String.valueOf(intDBIndexCount), strSubject, strMaker, "0", strContent}; 
						strDB[i] = strTemp;
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
				for(int i=0; i<strDB.length; i++){
					if(strDB[i] != null){
						if(strIndex.equals(strDB[i][0])){
							//해당 게시글이 존재할경우 출력
							//@조회했으니 카운터 +1
							strDB[i][3] = String.valueOf( Integer.parseInt( strDB[i][3] ) + 1 ); 
							//@상세보기 출력
							System.out.println("\t----------------------------------------------------------------------------");
							System.out.println( "\t■제목 : " + strDB[i][1] );
							System.out.print( "\t■번호 : " + strDB[i][0] );
							System.out.print( "\t ■글쓴이 : " + strDB[i][2] );
							System.out.print( "\t ■조회수 : " + strDB[i][3] );
							System.out.println();
							System.out.println( "\t■내용 : " + strDB[i][4] );
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
				for(int i=0; i<strDB.length; i++){
					if(strDB[i] != null){
						if(strIndex.equals(strDB[i][0])){
							//해당 게시글이 존재할경우 출력
							System.out.print("\t● 제목 : ");
							String strSubject = scan.nextLine();
							System.out.print("\t● 글쓴이 : ");
							String strMaker = scan.nextLine();
							System.out.print("\t● 내용 : ");
							String strContent = scan.nextLine();
							strDB[i][1] = strSubject;//제목 
							strDB[i][2] = strMaker;//작성자
							strDB[i][4] = strContent; //내용							
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
				for(int i=0; i<strDB.length; i++){
					if(strDB[i] != null){
						if(strIndex.equals(strDB[i][0])){
							//해당 게시글이 존재할경우 출력
							 System.out.print("\t● 정말 삭제하시겠습니까?(y or n) : ");
							 if(scan.nextLine().equals("y")){
								 strDB[i] = null;
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

	
	public static void PrintList(String[][] argsStrTarget, int argsIntDBIndexCount) {
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
			for(String[] arr : argsStrTarget){
				if(arr != null && intPrintTaregetNo == Integer.parseInt(arr[0]) ){
					System.out.print(" " + arr[0]); //번호
					System.out.print("\t\t");
					System.out.print(arr[1]); //제목
					System.out.print("\t\t\t");
					System.out.print(arr[2]); //글쓴이
					System.out.print("\t\t");
					System.out.println(arr[3]); //조회수
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