package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exam02") //공통경로
public class Exam02Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam02/index";
	}	

	//■ 6-1	
	@RequestMapping("/join")
	public String join(Member02 member){ 	
		logger.info("======= join 요청처리");
		logger.info("getMid : " + member.getMid() );
		logger.info("getMname : " + member.getMname() );
		logger.info("getMage : " + member.getMage() );
		return "exam02/index";
	}
	
	//■ 1
	@RequestMapping("/login")
	public String login(
		@RequestParam("id") String mid, 
		@RequestParam("password")  String mpassword ){
		logger.info("======= login 요청처리");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);
		return "exam02/index";
	}		
	
	//■ 2	
	@RequestMapping("/order")
	public String order( String pid, String pname, String pprice, String pcompany ){
		logger.info("======= order 요청처리");
		logger.info("pid : " + pid);
		logger.info("pname : " + pname);
		logger.info("pprice : " + pprice);
		logger.info("pcompany : " + pcompany);
		return "exam02/index";
	}			
	
	//■ 3
	@RequestMapping("/write")
	public String write(	@RequestParam(defaultValue="1") int bno,
								String title, String content, 
								@RequestParam(defaultValue="0") int hitcount ){
		logger.info("======= write 요청처리");		
		logger.info("bno : " + bno);
		logger.info("title : " + title);
		logger.info("content : " + content);
		logger.info("hitcount : " + hitcount);
		return "exam02/index";
	}
	
	
	//■ 4
	@RequestMapping("/update")	                        
	public String update(	@RequestParam(defaultValue="1") int bno,
								String title, String content, 
								@RequestParam(value="count", defaultValue="0") int hitcount ){
		logger.info("======= update 요청처리");
		logger.info("bno : " + bno);
		logger.info("title : " + title);
		logger.info("content : " + content);
		logger.info("hitcount : " + hitcount);
		return "exam02/index";
	}

	//■ 5	
	@RequestMapping("/send")	                        
	public String update(	Board board ){
		logger.info("======= send 요청처리");
		logger.info("bno : " + board.getBno() );
		logger.info("title : " + board.getTitle() );
		logger.info("content : " + board.getContent() );
		logger.info("hitcount : " + board.getHitcount() );
		return "exam02/index";
	}	
}