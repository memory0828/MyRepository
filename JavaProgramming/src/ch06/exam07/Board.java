package ch06.exam07;

public class Board {
	int no;
	String title;
	String content;
	String writer;
	int hitcount;
	
	//Consturtor
	Board(){}
	Board(int no){
		//int a = 10;
		this(no, null, null, null, 0);
		//this를 통해 다른 생성자를 호출할수있는데, 이호출은 첫번째 실행문이어야함
		int b = 10;
	}
	Board(int no, String title){
		this(no, title, null, null, 0);
	}
	Board(String title, int no){
		this(no, title, null, null, 0);
	}
	Board(int no, String title, String content){
		this(no, title, content, null, 0);
	}
	Board(int no, String title, String content, String writer){
		this(no, title, content, writer, 0);
	}
	Board(int no, String title, String content, String writer, int hitcount){
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hitcount = hitcount;
	}
	
	//Consturtor

	//Method

}
