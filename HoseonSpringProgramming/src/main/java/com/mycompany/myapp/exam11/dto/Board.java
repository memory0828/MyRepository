package com.mycompany.myapp.exam11.dto;
//dto = model = vo 객체

public class Board {
	private String bwriter;
	private String btitle;
	private String bcontent;
	
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}	
	
	
}
