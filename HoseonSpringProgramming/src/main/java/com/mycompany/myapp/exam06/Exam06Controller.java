package com.mycompany.myapp.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
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
		logger.info("WebClient 종류" + request.getHeader("User-Agent"));
		
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
		
		//★2. 바이너리 데이터 : 그림을 보내고 싶을떄
		response.setContentType("image/jpeg");
		//브라우저에 그냥 보여주는게 아니라 다운로드하게끔 만들려면?
		//====== 헤더 추가! Start
		//attachment:첨부파일형태 / filename= 이거 안들어가면 요청메소드가 파일이름이됨
		//response.setHeader("Content-Disposition", "attachment; filename=\"pho to1.jpg\""); //\" \" 를 붙여줌으로 중간에 공백이있어도 전체를 파일이름으로 인식함
		//한글로 된 파일 이름 다운로드할때
		//response.setHeader("Content-Disposition", "attachment; filename=\"사진2.jpg\""); //이렇게하면 파일이름이 이상하게 깨짐
		// 그래서
		/*
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName, "UTF-8"); //파일이름 자체를 UTF-8로 인코딩을 해준다.
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //이렇게하면 한글파일이름도 다운로드됨
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/사진2.jpg"); //이 경로에대한 절대 경로 얻기		
		*/
		//====== 헤더 추가! end
		
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
		//테그에서 <img src ="">와 같은 거와 결과는 동일하지만~ 처리방식의 차이다?!
	}
		
	@RequestMapping("/method3")
	public String method2(@RequestHeader("User-Agent") String userAgent) {
		//method1처럼 헤더값을 얻어 처리할수 있지만 좀더 편한 방법이 있다
		//그럼 어떻게하면 헤더의 값을 쉽게 얻을 수 있냐? 이걸 위해 @(어노테이션)이 제공된다.
		//요청 http에 헤더값으로 넘어오는 것들 중에서 String userAgent을 통해 매개변수로 값을 받아보자
		//@RequestHeader("User-Agent") String userAgent 이렇게 추가하면 됨!
		//이렇게 하면 method1처럼 따로 얻어오는 과정 필요없이 매개변수의 값으로 바로 사용할수있음
		//@RequestHeader("User-Agent")은 헤더의값을 매게변수의 값으로 바로 받아오게 해주는 역할
		//즉 이렇게 @RequestHeader("") 를 이용하게되면 헤더의 값을 매게변수에 바로 대입시킬수있따.
		
		//이렇듯 method1과 다르게 간략해짐
		if(userAgent.contains("Chrome") ){
			logger.info("브라우져 종류 : 크롬");
		}else if(userAgent.contains("Trident/7.0")){
			logger.info("브라우져 종류 : 익스플로러 11");					
		}else if(userAgent.contains("MSIE")){
			logger.info("브라우져 종류 : 익스플로러 10이하");
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method4CreateCookie")
	public String method4(HttpServletResponse response) throws UnsupportedEncodingException{
		//public void setMaxAge(int expiry)
		//단위는 초단위
		//양수 : 이 기간동안 쿠키 저장
		//0 : 기존의 저장되어 있는 쿠키 삭제
		//음수 : 쿠키를 저장하지 말아아라(하드디스크에)
		
		//쿠키 생성1
		Cookie cookie1 = new Cookie("mid", "fall"); //  .getName()하면 이게 : mid / .getValue()하면 이게 : fall
		
		//쿠키 생성2
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8"); //url인코딩(쿠키값을 한글로 처기하기 위해서)
		Cookie cookie2 = new Cookie("mname", name);
		cookie2.setMaxAge(60); //60초간 저장
		
		//쿠키 보내기(저장) - 응답 헤더에 쿠키 정보를 저장(HttpServletResponse response 필요)
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "exam06/index";		
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException{
		//★방법1. (오리지널)
		//쿠키받기 - 요청헤더에 쿠키정보를 읽기(HttpServletRequest request 필요)
		//한글 떄문에 url디코딩 작업
		Cookie[] cookies = request.getCookies();
		if( cookies != null ){
			for( Cookie cookie : cookies){
				String name = cookie.getName();
				String value = null;
				if(name.equals("mname")){
					value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else {
					value = cookie.getValue();
				}
				System.out.println(cookie.getName() + ":" + value);
			}
		}
		return "exam06/index";		
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")
	public String method4ReceiveCookieHow2(@CookieValue(defaultValue="") String mid, @CookieValue(defaultValue="") String mname){
		//★방법2. (바로 받는 방법) 스프링책(307p) 내용 - @CookieValue
		//@CookieValue String mid 의 뜻은 쿠키 이름중에서 mid가 넘어오면 그 값을 대입한다 의 뜻
		//즉 mid 이건 쿠키이름에 따라 달라지는 거지!
		//현재 코드 상에서는 쿠키의 값이 안넘어오면 에러 나게 되어있음 그래서 (defaultValue="")을 추가해서 이 에러를 잡는다
		
		//url 디코딩까지 다되어있음! 편리!
		System.out.println(mid);
		System.out.println(mname);

		return "exam06/index";		
	}
	
	@RequestMapping("/method4DeleteCookie")
	public String method4DeleteCookie(HttpServletResponse response){
		//값은 중요치않음
		Cookie cookie1 = new Cookie("mid","");
		cookie1.setMaxAge(0); //0으로 삭제(메모리뿐만아니라 하드디스크의 쿠키까지도)
		
		Cookie cookie2 = new Cookie("mname","");
		cookie2.setMaxAge(0); //0으로 삭제(메모리뿐만아니라 하드디스크의 쿠키까지도)
		
		//쿠키를 새로 보내는듯한 코드지만 MaxAge(0)을 줌으로서 쿠키를 삭제하는 명령어가 되는것
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "exam06/index";		
	}	
	
	@RequestMapping("/method5SetObject")
	public String method5SetObject(HttpSession session){
		//객체 생성
		Member member = new Member("fall", "한가을");
	
		//HttpSession에 객체 저장
		session.setAttribute("member",  member); //member이라는 키이름의 member객체의 값을 저장
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method5GetObject(HttpSession session){
		//HttpSession에서 객체 얻기
		Member member= (Member) session.getAttribute("member"); //member이라는 키 이름의 값 얻어오기
		//여기선 session 디폴트값 자체가 의미없다. 밑에 null이 처리하기때문에
		//이런 종류의 코드를 사용할떄는 반드시 null체크가필요 (세션에 저장이 안되어있을 때 null이 발생해서 예외가 발생하기때문에)
		if(member != null ){
			System.out.println("mid:" + member.getMid());
			System.out.println("mid:" + member.getMname());
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method5RemoveObject")
	public String method5RemoveObject(HttpSession session){
		//HttpSession에서 객체 얻기
		session.removeAttribute("member");
		return "exam06/index";
	}
	
}