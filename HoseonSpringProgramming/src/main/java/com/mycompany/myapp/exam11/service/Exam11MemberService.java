package com.mycompany.myapp.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11MemberDao;
import com.mycompany.myapp.exam11.dto.Member;

//@Component 관리객체로 만들겠다! @Controller는 컨트롤러에만 붙이는거고 그외에는 다 Component이다!
/*이상태에서 다른 exam12같은곳에서 MemberService를 만들어  @Component를 적용하면
다시 등록이 안됨.. 그이유는 똑같은 클래스이름을 가지고 관리객체로 등록되는데
같은 이름은 등록이 안되서! 그래서 취찮지만 이름을 좀 구분해줘야함
Exam11MemberService 이런식으로 구분함
혹은 @Component("") ""안에 이름 넣어주는 식으로 구분해야함*/
@Component
public class Exam11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	public static final int LOGIN_SUCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;

	@Autowired
	private Exam11MemberDao memberDao;

	public void join(Member member){
		logger.info("join 요청처리@");
		memberDao.insert(member);
	}

	public int login(String mid, String mpassword){
		logger.info("login 요청처리@");
		Member member = memberDao.select(mid);
		if(member == null){
			//아이디가 존재하지 않을때
			return LOGIN_FAIL_MID;
		}else{
			//아이디가 존재할때
			if(member.getMpassword().equals(mpassword)){
				return LOGIN_SUCESS;
			}else{
				return LOGIN_FAIL_MPASSWORD ;
			}
			
		}
	}
}
