package com.mycompany.myapp.exam11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11BoardDao;
import com.mycompany.myapp.exam11.dto.Board;

//@Component 관리객체로 만들겠다! @Controller는 컨트롤러에만 붙이는거고 그외에는 다 Component이다!
/*이상태에서 다른 exam12같은곳에서 MemberService를 만들어  @Component를 적용하면
다시 등록이 안됨.. 그이유는 똑같은 클래스이름을 가지고 관리객체로 등록되는데
같은 이름은 등록이 안되서! 그래서 취찮지만 이름을 좀 구분해줘야함
Exam11MemberService 이런식으로 구분함
혹은 @Component("") ""안에 이름 넣어주는 식으로 구분해야함*/
@Component
public class Exam11BoardService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardService.class);
	
	@Autowired
	private Exam11BoardDao boardDao;
	
	public void write(Board board){
		logger.info("write 요청처리@");
		boardDao.insert(board);
	}

	public List<Board> getList(){
		logger.info("getList 요청처리@");
		List<Board> list = boardDao.selectList();
		return list;
	}
	
}
