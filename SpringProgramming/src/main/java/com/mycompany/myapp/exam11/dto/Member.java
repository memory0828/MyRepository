package com.mycompany.myapp.exam11.dto;
//dto = model = vo 객체

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	private String mid;
	private String mname;
	private String mpassword;
	private String memail;
	private String mtel;
	private String mjab;
	private String[] mskill;
	private String maddress1;
	private String maddress2;
	
	//스프링이 똑똑하지 않아서 Date형식을 넘겨받을때 이게 Date형식이다라는 것을 알려줘야함
	//즉 날짜는 반드시 형식을 지정해줘야함. 다른 문자나 숫자들은 알아서하는데 이건 특이함!
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date mbirth;
	
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
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMjab() {
		return mjab;
	}
	public void setMjab(String mjab) {
		this.mjab = mjab;
	}
	public String[] getMskill() {
		return mskill;
	}
	public void setMskill(String[] mskill) {
		this.mskill = mskill;
	}
	public String getMaddress1() {
		return maddress1;
	}
	public void setMaddress1(String maddress1) {
		this.maddress1 = maddress1;
	}
	public String getMaddress2() {
		return maddress2;
	}
	public void setMaddress2(String maddress2) {
		this.maddress2 = maddress2;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}

	
	
	
}
