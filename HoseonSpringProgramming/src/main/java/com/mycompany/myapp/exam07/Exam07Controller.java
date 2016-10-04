package com.mycompany.myapp.exam07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam07") //공통경로
public class Exam07Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam07Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam07/index";
	}

	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		logger.info("=========== method1 요청처리");
		request.setAttribute("data1", "value1"); 
		request.setAttribute("data2", "value1");
		return "exam07/usedata";
	}

	@RequestMapping("/method2")
	public String method2(HttpSession session){
		logger.info("=========== method2 요청처리");
		session.setAttribute("data1", "value1"); 
		session.setAttribute("data2", "value1");
		return "exam07/usedata";
	}
	
	// 스프링에서 많이 쓴는 방식!
	@RequestMapping("/method3")
	public String method3(Model model){
		logger.info("=========== method3 요청처리");
		//기본값으로 HttpServletRequest에 저장됨
		model.addAttribute("data1", "value1"); 
		model.addAttribute("data2", "value1");
		return "exam07/usedata";
	}
	
}