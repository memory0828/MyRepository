package com.mycompany.myapp.exam03;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam03") //공통경로
public class Exam03Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam03Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam03/index";
	}

	@RequestMapping("/join")
	public String join(Member member){
		logger.info("=========== join 요청처리");
		logger.info( member.getMid() );		
		logger.info( member.getMname() );
		logger.info( member.getMpassword() );
		logger.info( member.getMemail() );
		logger.info( member.getMtel() );
		logger.info( member.getMjab() );
		logger.info( member.getMaddress1() );
		logger.info( member.getMaddress2() );
		logger.info( member.getMbirth() );		
		logger.info(Arrays.toString( member.getMskill() ) );
		return "exam03/index";
	}	
}
