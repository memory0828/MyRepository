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
	
	//설계시 고려된점 :
	//세가지의 상태가 생기면 상수를 설정하도록
	//두가지의 상태가 생기면 보이드로도 충분
	@Autowired
	private MemberDao memberDao;
	
	public int Join(Member member) {
		memberDao.insert(member);
		return JOIN_SUCCESS;
		
	}
	
	public int login(String mid, String mpassword, HttpSession session) {
		Member member = memberDao.selectByMid(mid);
		//아이디로 검색된게 없을때
		if(member == null) return LOGIN_FAIL_MID;
		//비빌번호가 틀릴때
		if(member.getMpassword().equals(mpassword) == false) return LOGIN_FAIL_MPASSWORD;
		session.setAttribute("login",  mid);
		return LOGIN_SUCCESS; 
	}
	
	//서비스에는 독립적으로 매소드만 구성되어 놓고 기타 종속 API는 사용하지 않는 것이 좋다. 즉 권장한다
	//근데 여기서 로그아웃을 구현하려면 HttpSession을 사용해야하기때문에, HttpSession가 있어야 실행이되는
	//종속 API를 가진 상태로 운영되야한다
	//그래서 로그아웃하려면 세션을 이용하게 됐고, 그래서 이 logout() 메소드에서 세션을 받아 쓴다
	//이게 꼭 나쁜방법이 아니다. 결국 이렇게 설계해도 스프링에서 사용되는 소스기 때문에, 큰 문제는 없다~
	public int logout(HttpSession session) {
		session.removeAttribute("login");
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
	
	public Member info(String mpassword, HttpSession session) {
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return null;
		return member;
		
	}
	public int modify(Member member) {
		return 0;
	}
	
	public int withdraw(String mpassword, HttpSession session) {
		String mid = (String)session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return WITHDRAW_FAIL;
		memberDao.delete(mid);
		logout(session);
		return WITHDRAW_SUCCESS;
	}
	
	public boolean checkMid(String mid) {
		return false;
	}
}

