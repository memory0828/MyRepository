package ch06.homework;

public class Board {
	//Field
	int no; //"번호" - index 코드
	String subject; //"제목"
	String writer; // "글쓴이"
	int cnt; //"조회수"
	String content; //"내용"
	
	//Const
	Board(int no, String subject, String writer, String content){
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.cnt = 0; //자동
	}	
	
	//Method
	void plusCnt(){
		cnt++;
	}

}
