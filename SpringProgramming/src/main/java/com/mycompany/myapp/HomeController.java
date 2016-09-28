package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		System.out.println("index() 실행1"); //기존에 에러 로고를 처리하는법(나중에 지워야함)
		logger.info("index() 실행2"); //향상된 로고를 처리하는 법(오우 좋다!)
		logger.debug("index() 실행2"); //향상된 로고를 처리하는 법(오우 좋다!)
		return "home"; //jsp 이름과 똑같아야함
	}
	
	@RequestMapping("/news")
	public String news() {
		
		return "news";
	}
	
}
