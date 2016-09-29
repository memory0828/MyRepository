package com.mycompany.myapp.exam02;

//파라미터를 객체로 바꾸고 싶다면
//파라미터 name과 필드의 name 동일해야된다. 
//spring이 알아서 똑똑하게 name을 기준으로 파라미터와 필드를 매칭시켜준다.
//그래서 필드순서가 바꿔어도 잘됨. 근데 당연하지만 name이 달라지면 매칭을 할수 없으니 안되는거지!
public class Board {
	private int bno;
	private String title;	
	private String content;
	private int hitcount;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
}
