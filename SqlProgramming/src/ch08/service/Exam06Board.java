package ch08.service;

import ch08.dao.BoardDao;

public class Exam06Board {
	public static void main(String[] args) {
		//보드 테이블의 삭제
		BoardDao dao = new BoardDao();
		dao.deleteByBno(13);
	}
}
