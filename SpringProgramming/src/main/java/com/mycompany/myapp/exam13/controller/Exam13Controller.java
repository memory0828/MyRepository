package com.mycompany.myapp.exam13.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam13.dto.Member;
import com.mycompany.myapp.exam13.service.Exam13MemberService;

@Controller
@RequestMapping("/exam13")
public class Exam13Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam13Controller.class);

	@Autowired
	private Exam13MemberService exam13MemberService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam13/index";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String joinFrom(){
		logger.info("=========== memberJoinForm 요청처리");
		return "exam13/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("=========== memberJoin 요청처리");
		exam13MemberService.join(member);
		return "redirect:/exam13/index";
	}
	
	@RequestMapping("/memberInfo")
	public String join(String mid, Model model){
		logger.info("=========== memberInfo 요청처리");
		Member member = exam13MemberService.info(mid);
		model.addAttribute("member", member);
		return "exam13/memberInfo";
	}
}

