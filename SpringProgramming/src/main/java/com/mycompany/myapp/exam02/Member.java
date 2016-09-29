package com.mycompany.myapp.exam02;

//파라미터를 객체로 바꾸고 싶다면
//파라미터 name과 필드의 name 동일해야된다. 
//spring이 알아서 똑똑하게 name을 기준으로 파라미터와 필드를 매칭시켜준다.
//그래서 필드순서가 바꿔어도 잘됨. 근데 당연하지만 name이 달라지면 매칭을 할수 없으니 안되는거지!
public class Member {
	private String mid;
	private String mname;
	private int mage;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
}
