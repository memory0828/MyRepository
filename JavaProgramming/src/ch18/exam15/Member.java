package ch18.exam15;

import java.io.Serializable;
public class Member implements Serializable{
	private static final long serialVersionUID = -8521463662410451932L;
	private String mid;
	private String mname;
	transient private String mpassword;
	transient private static String mnation = "한국";
	private int mage;

	public Member(String mid, String mname, String mpassword, int mage) {
		this.mid = mid;
		this.mname = mname;
		this.mpassword = mpassword;
		this.mage = mage;
	}
	
	public static String getmnation() {
		return mnation;
	}
	public static void setmnation(String mnation) {
		Member.mnation = mnation;
	}	
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
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}

	
	
}
