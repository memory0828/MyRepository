package com.mycompany.myapp.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam04") //공통경로
public class Exam04Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam04/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET) //GET 방식으로 오면 이것을
	public String joinForm(){
		logger.info("=========== joinForm 요청처리");
		return "exam04/joinform";
	}	
	@RequestMapping(value="/join", method=RequestMethod.POST) //POST 방식으로 오면 이것을 
	public String join(Member04 member){
		logger.info("=========== join 요청처리");
		logger.info(member.getMsubject());
		logger.info(member.getMname());
		logger.info(member.getMcontents());
		return "exam04/index";
	}	
}
