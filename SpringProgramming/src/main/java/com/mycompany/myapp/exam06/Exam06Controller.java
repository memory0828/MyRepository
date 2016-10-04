package com.mycompany.myapp.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06") //공통경로
public class Exam06Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam06/index";
	}

	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		/*
		 * HttpServletRequest request 안에는 
		 * 요청 Http에 대한 모든 내용이 들어가있다.
		 */
		logger.info("=========== method1 요청처리");
		
		//클라이언트 IP얻기
		logger.info("WebClient IP" + request.getRemoteAddr()); //Web client의 주소
		//클라이언트 브라우저 종류 얻기
		logger.info("WebClient 종류" + request.getRemoteAddr()); //이것을 거쳐서
		if(request.getHeader("User-Agent").contains("Chrome") ){
			logger.info("브라우져 종류 : 크롬");
		}else if(request.getHeader("User-Agent").contains("Trident/7.0")){
			logger.info("브라우져 종류 : 익스플로러 11");					
		}else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("브라우져 종류 : 익스플로러 10이하");
		}
		
		//요청 파라미터 값 얻기
		logger.info("mid : " + request.getParameter("mid"));
		logger.info("mname : " + request.getParameter("mname"));								
		
		//쿼리 문자열 얻기 
		logger.info("쿼리 문자열 : " + request.getQueryString());
		logger.info("요청URL : " + request.getRequestURI() );
		logger.info("요청URL : " + request.getRequestURL() );
		logger.info("요청 방식 : " + request.getMethod() );
		//logger.info("시스템 파일 경로 : " + request.getRealPath("/WEB-INF/image/photo1.jpg") ); //.metadata ~~ 어디 어디 경로가 나오는데 그건 즉 실행할 때 주소라서
		logger.info("시스템 파일 경로 : " + request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg") );//위는 쓰지말고 이게 쓰는게 좋다
		return "exam06/index";
	}
	
	@RequestMapping("/method2")
	public void method2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/*
		 * HttpServletResponse
		 * 추가하고 싶을 땐 add 변경하고 싶을 땐 set~
		 * setStatus
		 *  - 상태번호 OK
 		 *  - 상태번호 설정
		 * Response
 		 * - OutputStream 역할을 한다
 		 * - Http 본문에 내용이 실린다.
		 */
		
		//★1. 문자를 보낼때
		//어떤 데이터를 전달할떄 xml포멧도 많이 쓰지만 application/json 포멧도 많이 씀 
		//response.setContentType("application/json; charset=UTF-8"); //application/json이 타입은 나중에 자바스크립트 할떄 나옴
		//보내는게 문자다 -> 아래 둘다 쓸수 있으니 판단해야한다.
		//OutputStream os = response.getOutputStream(); //이건 문자고 모고 다 보냄
		//PrintWriter pw = response.getWriter(); //이건 문자만보내는데, print 같은 명령어를 쓸수있으니깐 이게 편리!
		//pw.println("{mid:'fall', mname:'한가을'}"); //"{mid:'fall', mname:'한가을'}" 이런 형태가 application/json 이다
		//실행 결과 브라우저에 {mid:'fall', mname:'한가을'} 이렇게 출력되는데
		// 결과를 보면 알겠지만 자바스크립트 등이 사용할 데이터만 제공할떄 application/json으로 보내줌
		
		/* 
		위 response.setContentType ( "   " ) "" 이 사이의 내용이
		1. text/html 일 경우
		   pw.println은
		    <html>....</html> 이런 식의 내용이
		
		2. text/xml 일경우
		   pw.println은		
		   <book>...</book> 이런 식의 내용이
		   
		   들어가게됨. 즉 보낼때 어떤 타입의 데이터인지 response.setContentType ("") ""안에 지정해서 보내주고
		   보내주는 데이터는 그지정된 타입에 맞춤!
		*/
		
		//★2. 바이너리 데이터 : 그림을 보내고싶을떄
		response.setContentType("image/jpeg");
		OutputStream os2 = response.getOutputStream();
		//파일의 개발되는 경로로 사용하면 고정된 형태 사용됨으로 그냥 쓰면 안됨
		//그래서 동적으로 경로를 알아내야함
		//그럼 HttpServletRequest request 를 추가해서 아래처럼 해야함
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"); //이 경로에대한 절대 경로 얻기
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values))!= -1 ){
			os2.write(values, 0, byteNum);
		}
		os2.flush();
		is.close();
		os2.close();
		
	}
	
}

