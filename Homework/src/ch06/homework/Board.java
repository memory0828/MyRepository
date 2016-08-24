package ch06.homework;

public class Board {
	//Field
	int no;
	String subject;
	String writer;
	int cnt;
	String content;

	//Const
	
	
	void SetData(int no, String subject, String writer, String content){
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.cnt = 0;
		this.content = content;
	}
	
	void plusCnt(){
		cnt++;
	}
	//Method
	
	
}
