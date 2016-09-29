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
	/*======== [join] 기존 인수값 전달하는 방식에서  
	@RequestMapping("/join")
	public String join(String mid, String mname, String mage){
		logger.info("======= join 요청처리");
		logger.info("mid : " + mid);
		logger.info("mname : " + mname);
		logger.info("mage : " + mage);
		return "exam02/index";
	}
	*/
	//■ 6-2	
	//======== [join] 객체로 깔끔하게 인수값 전달하는 방식 으로 바꿔봄
	@RequestMapping("/join")
	public String join(Member member){ 	
		//Member member로 이렇게 객체를 전달하여 깔끔하게 만듬. 
		//이런객체( = vo(value object) = comand 객체 )라 함
		logger.info("======= join 요청처리");
		logger.info("getMid : " + member.getMid() );
		logger.info("getMname : " + member.getMname() );
		logger.info("getMage : " + member.getMage() );
		return "exam02/index";
	}
	
	//■ 1
	@RequestMapping("/login") //여기서 value=이 생략되어있는 상태임 실제론 @RequestMapping(value="/login") 다 
										//	모든 어노테이션은 디폴트속성 value=가 생략되어있는 상태이다
	public String login(
		@RequestParam("id") String mid, ////역시 value=이 생략되어있는상태임( 실제론 @RequestParam("value=id") String mid ) 
		@RequestParam("password")  String mpassword ){
	    // 인수전달 앞에 붙는 이것들의 뜻은 
		// - id로 전달된 데이터를 String mid에 대입해라
		// - password로 전달된 데이터를 mpassword에 대입해라	
		//만약. 파라미터 이름과 다른 이름으로 인수가 넘어왔을 경우에
			//@RequestParam을 통해서 처리해져야한다
			//파라미터와 인수이름이 똑같으면 이거 필요없지~알지?
			//( ★그런데 실제로 개발하다보면 요청파라미터 이름과
			//   서버쪽에서 사용하는 변수명이 안맞을 경우가 있는데 이럴 떄 유용하다 )
		logger.info("======= login 요청처리");
		logger.info("mid : " + mid);
		logger.info("mpassword : " + mpassword);
		return "exam02/index";
	}		
	
	//■ 2	
	@RequestMapping("/order")
	public String order( String pid, String pname, String pprice, String pcompany ){
	//public String order( int pid, String pname, int pprice, String pcompany ){
		//--> 이렇게 형을 바꾸거나( String pprice -> int pprice)
	//public String order( int pid, int pprice, String pname, String pcompany ){
		//--> 이렇게 순서를 뒤바꿔도 
	//Spring은 인수값을 알아서 형변환해 주거나, 넘겨받는 인수이름와 파라미터 이름을 매칭해 알아서 값을 넣어준다.
	//( 그래서 당연한 말이지만, 인수 이름과 파라미터 이름이 동일해야겠지?ㅋㅋ )
	//이렇듯 원래는 String로 받아야하는데 이렇게 하면 Spring이 숫자로 변화해서 저장해주니 편리하고
	//자주않쓰겠지만(내생각) 순서도 알아서 맞춰주니 Spring은 참 똑똑하다
		logger.info("======= order 요청처리");
		logger.info("pid : " + pid);
		logger.info("pname : " + pname);
		logger.info("pprice : " + pprice);
		logger.info("pcompany : " + pcompany);
		return "exam02/index";
	}			
	
	//■ 3
	@RequestMapping("/write")
	//파라미터가  int bno, String title, String content, int hitcount 들이 있을때
	//만약에 인수가 전달될 때 int bno나  int hitcount에 해당하는 값들이 안넘어 올떄는 이 것들에 어떤값을 넣을 것인가
	//인수가 넘어오지 않으면 null 값이 적용되는데 String형이야 null로 들어가서 그나마 괜찮겠지만
	//int bno 같은 넘들은 넘어오지 않으면 null이 들어가는데, 
	//이러면 당연히 100% 에러!( int에 null??ㄸㄸ) 그래서 디폴트값을 주자!!!!	
	//그 방법은
	//@RequestParam을 이용해서 defaultValue값을 지정해주면 된다.
	//   ( 즉, 이건 인수가 넘어오지 않을 경우에 대비해서 하는것이다)
	public String write(	@RequestParam(defaultValue="1") int bno,
								String title, String content, 
								@RequestParam(defaultValue="0") int hitcount ){
		//이렇게 인수가 안넘어오면 알아서 defaultValue 값으로 값을 파라미터에 넣어줌
		//당연히 값이 넘어오면 넘어온 값이 우선적으로 들어가겠지!
		logger.info("======= write 요청처리");		
		logger.info("bno : " + bno);
		logger.info("title : " + title);
		logger.info("content : " + content);
		logger.info("hitcount : " + hitcount);
		return "exam02/index";
	}
	
	
	//■ 4
	//이건 ■ 3의 응용인데, 
	//1. 파라미터 값이 안 넘어 올 경우 기본값 넣어 주는거 
	//                    +
	//2. 인수값이 파라미터 이름과 다른 이름으로 넘어올 경우에 지정해서 받는 방법이다. 
	@RequestMapping("/update")	                        
	public String update(	@RequestParam(defaultValue="1") int bno,
								String title, String content, 
								@RequestParam(value="count", defaultValue="0") int hitcount ){
								//( @RequestParam는 요청파라미터의 값을 받기 위한것으로)
								//이 위의 뜻은 hitcount로 넘어오면 바로 값을 넣고 
								//인닐경우에[ count라는 변수명으로 인수값이 전달된다면 int hitcount에 그 값을 넣고
								//근데도 아무값도 없을땐 int hitcount에 0으로 초기화

								//@RequestParam()에서 (  ) 사이에
								//두개 이상의 속성이 들어갈떄는 반드시 value="", 으로 들어가 주어야한다(생략된 상태라서)
								//앞에서 value=이게 생략된 상태라는건 이미 봐서 알것이다 ㅎㅎㅎ ㅋ
		logger.info("======= update 요청처리");
		logger.info("bno : " + bno);
		logger.info("title : " + title);
		logger.info("content : " + content);
		logger.info("hitcount : " + hitcount);
		return "exam02/index";
	}

	////////////////////////////////////////////////////////////////////////////
	//★근데 이렇게 인수가 나열되니깐 복작해 이걸 해결하려면 객체로 바꾸면 됨! 아래서 그 방법 나옴
	////////////////////////////////////////////////////////////////////////////
	//■ 5	
	@RequestMapping("/send")	                        
	public String update(	Board board ){
		//이렇게 Board board 로 파라미터를 쓰니깐 깔끔함!
		//그래서 저 위의 인수값들을 필드로 가지는 클래스를 만들어 그걸 객체로 씀
		//관련된 내용은 Board 클래스가서 봐!
		//                  이런 파라미터 객체를( = vo(value object) = comand 객체 )라 함
		//★실제로 이런 방식 많이 씀
		logger.info("======= send 요청처리");
		logger.info("bno : " + board.getBno() );
		logger.info("title : " + board.getTitle() );
		logger.info("content : " + board.getContent() );
		logger.info("hitcount : " + board.getHitcount() );
		return "exam02/index";
	}	
}
