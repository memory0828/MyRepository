package ch11.exam01;

public class Board {
	private int bno;
	private String title;
	private String content;
	
	public Board(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Board){
			Board target = (Board)obj;
			if(bno == target.bno){ 
				//target.bno이거 엄밀히말해서 문법적으로 틀림
				//bno 는 private int bno;이기때문에 외부에서 접근이 안됨
				//그래서 원래대로면 private int bno; -> public, default,, 으로 바꾸면 맞음
				//혹은 get으로 받아서 비교하면 됨
				//그런데 허용되는건.. 일단 같은 종류기 때문에 접근가능하다로 정리하자(엄밀히말해선 문법적으로틀리다)
				return true;
			}
		}
		return false;
	}
}
