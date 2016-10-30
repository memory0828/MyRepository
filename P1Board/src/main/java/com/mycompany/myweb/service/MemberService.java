package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;



@Component
public class MemberService {
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;

	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_MID=1;
	public static final int LOGIN_FAIL_MPASSWORD=2;
	
	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;

	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS=0;
	public static final int WITHDRAW_FAIL=1;
	
	////////////////////////////////////////////////////////////////////////////////
	//Service를 이용할 떄 DTO DAO만 이용할 수 있또록 설계~~~
	////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private MemberDao memberDao;
	
	public int Join(Member member) {
		
		memberDao.insert(member);
		return JOIN_SUCCESS;
		
	}
	
	public int login(String mid, String mpassword) {
		Member member = memberDao.selectByMid(mid);
		//아이디로 검색된게 없을때
		if(member == null) return LOGIN_FAIL_MID;
		//비빌번호가 틀릴때
		if(member.getMpassword().equals(mpassword) == false) return LOGIN_FAIL_MPASSWORD;
		return LOGIN_SUCCESS; 
	}
	
	public int logout(String mid) {
		return LOGOUT_SUCCESS;
	}
	
	public String findMpassword(String mid, String memail) {
		Member member = memberDao.selectByMid(mid);
		//아이디로 검색된게 없을때
		if(member == null) return null;
		//가 틀릴때
		if(member.getMemail().equals(memail) == false) return null;
		return member.getMpassword();
	}
	
	public String findMid(String memail) {
		return memberDao.selectByMemail(memail);
	}
	
	public Member info(String mid, String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return null;
		return member;
		
	}
	public int modify(Member member) {
		Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember.getMpassword().equals(member.getMpassword()) == false)  return MODIFY_FAIL;
		int row = memberDao.update(member);
		if(row != 1) return MODIFY_FAIL;
		return MODIFY_SUCCESS; 
	}
	
	public int withdraw(String mid, String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return WITHDRAW_FAIL;
		memberDao.delete(mid);
		logout(mid);
		return WITHDRAW_SUCCESS;
	}
	
	public boolean checkMid(String mid) {
		Member member = memberDao.selectByMid(mid);
		if(member == null) return false;
		return true;
	}
}

