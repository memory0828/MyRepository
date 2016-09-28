package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

/*
 * 이 Java™ Platform, Standard Edition 8 http://docs.oracle.com/javase/8/docs/api/index.html
 * Doc에는 javax.servlet로 시작하는건 없다
 * 이건 자바 Standard Edition DOC니
 * Enterprise Edition DOC에서 찾아봐야함
 */

/*
 * 클라이언트가 전달하는 
 * 요청http에 대한 정보는 request 객체를 통해 얻을수있다
 * 그래서 결국 req를 사용하게 되면 클라이언트가 보낸 요청 http내용을 알수있고
 * 
 * 서버가 어떤 요청을 처리하고
 * 응답 http에 대한 정보는 response객체를 통해 얻을수있다.
 * 그래서 결국 resp를 사용하게 되면 서버가가 보낸 응답 http내용을 알수있고
 * 
 * 즉,
 * = HttpServletRequest req, 
 * Http통신을 하는 서블릿에서 사용하는 Request 인터페이스 구현 객체 req
 * 
 * = HttpServletResponse resp
 * Http통신을 하는 서블릿에서 사용하는 Response 인터페이스구현 객체 resp
 */

public class NowServlet extends HttpServlet{
	//필드
	private String location;
	
	//생성자
	public NowServlet(){
		/* 서블릿은 객체가 한번만들어지면 그 객체 하나만 쓴다.
		 * 즉, 클라이언트가 최초로 요청HTTP를 보낼 때 그때 객체를 생성하고
		 * 한번생성한 객체는 계속 재사용( 다른브라우져, 다른 ip의 접속자가 있든지간에 )
		 * 그래서 최초 객체를 만들때는 클라이언트쪽에서 나타는 속도는 느리다! 이걸해결하기위해 미리 객체
		 * 생성의 필요가 있다.
		*/
		System.out.println("Now Servlet 객체 생성");
	}
	
	//초기화 매소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		// web.xml 에 <init-param>의 값을 받기 위한 메소드!  
		location = config.getInitParameter("location"); //<init-param>의 contextConfigLocation값을 리턴
		System.out.println("Now Servlet 초기화");		
	}
	
	@Override
	//protected는 같은 패키지 또는 자식클래스면 사용가능
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이건 헤더행에 추가되서 날라감
		//resp.setHeader("text/html;", "charset=UTF-8"); //이렇게 헤더행에 내용을 넣어도되지만
		//아래처럼 해도된다. 근데 따로 있는 이유는 ContentType가 중요하기 떄문에 따로 메소드가 있는거임 
		resp.setContentType("text/html; charset=UTF-8"); //요청내용은 안받고 응답은 작성한다.
		//                                    --        ---
		//									   1         2
		                                     //1. 여긴 공백이 들어가도됨 text/html;cha 이거 됨
											             //2. 공백들어가면 안됨 charset = UTF-8 이거 안됨
		                                             
		//ContentType 본문에 대한 내용이 뭔지를 뜻하는 MIME 기억나지? ㅋㅋ
		//resp.setContentType( 이안에 text/html;... 이런 내용 넣으면 됨 )
		
		//이것들은 본문행에 추가되서 날라감
		//OutputStream os = resp.getOutputStream(); //이건 문자,그림등 모두 보낼때
		PrintWriter out = resp.getWriter(); //이건 문자만보낼때
		/*
		 이런 정보를 보낼 때 쓰는 거임 : <html><head>..</head><body>...</body></html> 
		*/				
		out.println("<html>");
			out.println("<head><meta charset='UTF-8'></head>");
			out.println("<body>");
				out.println("현재시간: " + location + "시간: " + new Date().toString());			
			out.println("</body>");
		out.println("</html>");

	}
}
