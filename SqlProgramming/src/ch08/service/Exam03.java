package ch08.service;

import java.util.Date;

import ch08.dto.Member;
import ch08.dao.MemberDao;

public class Exam03 {
	public static void main(String[] args) {
		//맴버테이블의 삭제
		MemberDao dao = new MemberDao();
		dao.deleteByMid("user3");
	}
}
