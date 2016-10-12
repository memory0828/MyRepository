package com.mycompany.myapp.exam11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam11.dto.Board;
import com.mycompany.myapp.exam11.dto.Member;
import com.mycompany.myapp.exam11.service.Exam11BoardService;
import com.mycompany.myapp.exam11.service.Exam11MemberService;

@Controller //이렇게하면 디폴트 이름인데( 첫글자가 소문자로 시작하는)
@RequestMapping("/exam11")
public class Exam11Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);

	//필드 주입
	@Autowired
	private Exam11MemberService memberService;

	@Autowired
	private Exam11BoardService boardService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam11/index";
	}
	
	/////////////////////////////////////////////////////////////////
	//@어쭈구( ) 안에 들어가는 속성이 2개이상이되면 value값을 명시해줘야함
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("=========== memberJoin(GET) 요청처리");
		return "exam11/memberJoinForm";
	}
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(Member member){
		logger.info("=========== memberJoin(POST) 요청처리");
		logger.info( "Mid :" + member.getMid() );		
		logger.info( "Mname :" + member.getMname() );
		logger.info( "Mpassword :" + member.getMpassword() );
		logger.info( "Memail :" + member.getMemail() );
		logger.info( "Mtel :" + member.getMtel() );
		logger.info( "Mjab :" + member.getMjab() );
		logger.info( "Maddress1 :" + member.getMaddress1() );
		logger.info( "Maddress2 :" + member.getMaddress2() );
		logger.info( "Mbirth :" + member.getMbirth() );		
		logger.info( "Mskill :" + Arrays.toString( member.getMskill() ) );
		memberService.join(member);
		return "redirect:/exam11/memberLogin";
	}	
	
	
	/////////////////////////////////////////////////////////////////
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
	public String memberLoginForm(){
		logger.info("=========== memberLogin(GET) 요청처리");
		return "exam11/memberLoginForm";
	}
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memberLogin(String mid, String mpassword){
		logger.info("=========== memberLogin(POST) 요청처리");
		logger.info("mid : "+mid);
		logger.info("mpassword : "+mpassword);
		
		int result = memberService.login(mid, mpassword);
		if(result == Exam11MemberService.LOGIN_SUCESS){
			return "redirect:/exam11/index";
		}else if(result == Exam11MemberService.LOGIN_FAIL_MID){
			return "redirect:/exam11/memberLogin"; //redirect:뒤꺼는 jsp가 아닌 요청경로가 아니다 (즉. memberLoginForm.jsp가 아니다)
		}else{
			//result == Exam11MemberService.LOGIN_FAIL_MPASSWORD
			return "redirect:/exam11/memberLogin";
		}
	}

	
	@RequestMapping("/memberLogout")
	public String memberLogout(){
		logger.info("=========== logout 요청처리");
		return "redirect:/exam11/index";
	}
	
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("=========== boardWriteForm 요청처리");
		return "exam11/boardWriteForm";
	}
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("=========== boardWrite 요청처리");
		boardService.write(board);
		return "redirect:/exam11/index";
	}

	@RequestMapping(value="/boardList")
	public String boardList(Model model){
		logger.info("=========== boardList 요청처리");
		List<Board> list = boardService.getList();
		model.addAttribute("boardlist", list);
		return "exam11/boardList";
	}

	
}