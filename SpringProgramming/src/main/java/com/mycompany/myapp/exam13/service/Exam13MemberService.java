package com.mycompany.myapp.exam13.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam13.dao.Exam13MemberDao;
import com.mycompany.myapp.exam13.dto.Member;


@Component
public class Exam13MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam13MemberService.class);

	@Autowired
	private Exam13MemberDao dao; //주입받기
	//주입을 받아 쓰냐 안쓰냐는 어떤 한 메소드에서만 사용할경우에는 주입필요가없지만
	//여러 메소드에서 쓸거면 주입을 통해 사용한다
	
	public void join(Member member) {
		logger.info("join 처리");
		//★핵심코드(나머지는 악세서리 코드)
		//그럼 악세서리 코드없이 좀 간편화하게 할 수 없을까? 이렇게 간편해질수가!!!!
		int rowNo = dao.insert(member);
		logger.info(rowNo + "행이 저장됨");
		
	}

	public Member info(String mid) {
		logger.info("info 처리");
		Member member = dao.selectByMid(mid);
		return member;
	}

}
