package com.mycompany.myapp.exam08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam08") //공통경로
public class Exam08Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam08Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam08/index";
	}

	@RequestMapping("/join")
	public String join(){
		logger.info("=========== join 요청처리");
		return "redirect:/exam08/index";
	}

	@RequestMapping("/write")
	public String write(){
		logger.info("=========== write 요청처리");
		return "redirect:/exam08/list";
	}

	@RequestMapping("/list")
	public String list(){
		logger.info("=========== list 요청처리");
		return "exam08/list";
	}

	
}