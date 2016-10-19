package ch08.service;

import java.util.Date;

import ch08.dto.Board;
import ch08.dao.BoardDao;

public class Exam04Board {
	public static void main(String[] args) {
		//보드 테이블의 추가
		BoardDao dao = new BoardDao();
		Board board = new Board();

		board.setBno(1000);
		board.setBtitle("제목1000");
		board.setBcontent("내용1000");
		board.setBwriter("user1000");
		board.setBhitcount(1000);
		board.setBdate(new Date());
		dao.insert(board);
	}
}
