package ch08.service;

import java.util.Date;

import ch08.dto.Member;
import ch08.dao.MemberDao;

public class Exam02 {
	public static void main(String[] args) {
		//맴버테이블의 수정
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setMid("user7");
		member.setMage(35);
		member.setMbirth(new Date(1996,2,17));
		dao.update(member);
	}
}
