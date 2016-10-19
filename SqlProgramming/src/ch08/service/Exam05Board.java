package ch08.service;

import java.util.Date;

import ch08.dto.Board;
import ch08.dao.BoardDao;

public class Exam05Board {
	public static void main(String[] args) {
		//맴버테이블의 수정
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		board.setBno(12);
		board.setBhitcount(100);
		board.setBdate(new Date(1996,2,17));
		dao.update(board);
	}
}
