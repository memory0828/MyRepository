package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") //공통경로
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//세부경로
	@RequestMapping("/join") //http://localhost:8080/member/join 접근 경로임
	public String join(){
		logger.info("Join 요청처리");
		return "member/join";
	}
	
	@RequestMapping("/login")
	public String login(){
		logger.info("login 요청처리");		
		return "member/login";
	}	
	
	@RequestMapping("/logout")
	public String logout(){
		logger.info("logout 요청처리");		
		return "member/logout";
	}	
	
	@RequestMapping("/withdraw")
	public String withdraw(){
		logger.info("withdraw 요청처리");
		return "member/withdraw";
	}	
	
}
