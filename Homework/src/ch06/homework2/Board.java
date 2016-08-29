package ch06.homework2;

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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
