package com.mycompany.myapp.exam04_board;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/exam04_board")
@Controller
public class Exam04BoardController {
	private static final Logger logger = LoggerFactory.getLogger(Exam04BoardController.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("=====index 요청 처리");
		return "exam04_board/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)	//아래와 같은 URL 요청이지만 전송 방식을 달리하면 실행해 주겠다
	public String joinForm(){
		logger.info("=====joinForm 요청 처리");
		return "exam04_board/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("=====join 요청처리");
		logger.info("mid: " + member.getMid());
		logger.info("mname: " + member.getMname());
		logger.info("mpassword: " + member.getMpassword());
		logger.info("memail: " + member.getMemail());
		logger.info("mtel: " + member.getMtel());
		logger.info("mjob: " + member.getMjob());
		logger.info("mskil: " + Arrays.toString(member.getMskill()));
		logger.info("madress1: " + member.getMaddress1());
		logger.info("madress2: " + member.getMaddress2());
		logger.info("mbirth: " + member.getMbirth());
		
		return "exam04_board/index";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(){
		logger.info("=====writeform 요청 처리");
		return "exam04_board/writeform";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String board(String btitle, String bcontent){
		logger.info("=====write 요청 처리");
		logger.info("btitle: "+ btitle);
		logger.info("bcontet: "+bcontent);

		return "exam04_board/index";
	}
}
