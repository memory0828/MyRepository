package com.mycompany.myapp.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam04.Member;

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
	/*
	GET :: 1. 데이터양 제한 2. 문자만 가능 3. 주소란에 보임
	 	- 문자만 전송가능
		- 전송용량의 제한이 있다 브라우져마다
		  ( 브라우져마다 시작행의 내용을 제한하다 보니 이 시작행의 내용이 너무 많아지면 일정부분 짤려서 전송됨)
		- GET방식은 보내고자하는 모든 데이터를 시작행에 넣어서 보내고(즉 본문에 데이터를 넣어서 보내는게 아니다 = 그래서 본문 자체가 없다)
		- 그래서 브라우져 마다 시작행의 내용이 제한되다 보니 전송용량에 제한이 생기지!
		- 또 데이터가 브라우져의 url창에 다 달라 붙어 날라가기 때문에 보안에 취약하다
	POST :: 1. 데이터양 무제한 2. 모든 데이터 3 주소에 안보임
		- 문자뿐만아니라 파일이나 즉 문자외에 다른 데이터를 전송할수있다
		- 보내는 데이터의 양에 제한이 없다.
		- 시작행에는 요청경로만들어가고 데이터는 전부다 본문행에 들어간다.
		- 특징은 본문에 크기가 없다
	*/
	@RequestMapping(value="/join", method=RequestMethod.GET) //GET 방식으로 오면 이것을
	public String joinForm(){
		logger.info("=========== joinForm 요청처리");
		return "exam04/joinform";
	}	
	@RequestMapping(value="/join", method=RequestMethod.POST) //POST 방식으로 오면 이것을 
	public String join(Member member){
		logger.info("=========== join 요청처리");
		

		//문자가 깨져서 이렇게 처리하면 해결이 되는데 근데 그럼 매번 이렇게  소스가 복잡해짐 그래서
		//web.xml파일에 <filter>를 추가해서 자동으로 처리해주도록 만들필요가있음
		/*
		String name = member.getMname();
		try{
			name = new String(name.getBytes("iso-8859-1"), "UTF-8");
		}catch(Exception e){}
		logger.info( "★★★★★" + name );
		*/
		
		logger.info( member.getMid() );		
		logger.info( member.getMname() );
		logger.info( member.getMid() );
		logger.info( member.getMpassword() );
		logger.info( member.getMemail() );
		logger.info( member.getMtel() );
		logger.info( member.getMjab() );
		logger.info( member.getMaddress1() );
		logger.info( member.getMaddress2() );
		logger.info( member.getMbirth() );		
		logger.info(Arrays.toString( member.getMskill() ) );
		
		return "exam04/index";
	}	
}
