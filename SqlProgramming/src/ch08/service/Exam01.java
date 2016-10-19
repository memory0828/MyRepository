package ch08.service;

import java.util.Date;

import ch08.dto.Member;
import ch08.dao.MemberDao;

public class Exam01 {
	public static void main(String[] args) {
		//맴버테이블의 추가
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setMid("user7");
		member.setMname("사용자7");
		member.setMage(25);
		member.setMbirth(new Date());
		
		dao.insert(member);
	}
}
