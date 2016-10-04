package com.mycompany.myapp.exam05;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exam05") //공통경로
public class Exam05Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam05/index";
	}

	@RequestMapping("/index2")
	public ModelAndView index2(){
		logger.info("=========== index2 요청처리");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");
		return mav;
	}

	@RequestMapping("/index3")
	public void index3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/*
		 * void가 되면 jsp로 넘어갈 필요가 없다는 거다. 원래는 String이나 모델링뷰로 jsp의 이름을 리턴하게되는데
		 * 여기가 void가 된다는건 view이름이 없다 즉 jsp가 없다 즉 jsp가 실행이 안되니
		 * 응답이 어떻게 처리하겠다는건데? 응답을 안보내겠다? 그럼 브라우져에서는 아무것도 안나온다
		 * 그럼 여기서 응답을 만들어준다
		 * jsp필요없닌 이렇게 사용하는게 편리한 경우는 
		 * 1. 동영상과 같은 바이너리 데이터
		 * 2. html이 아닌 어떤 데이터만 전송하는 경우
		 */

		logger.info("=========== index3 요청처리");
		// 내가 보낼게 모냐 지정하는게, 이걸통해서 어떤 스트림을 처리할건지 판단
		// 이거 "  " 사이에  약속된 내용이 아닌 이상한 내용 넣으면 그냥 파일 다운로드 됨
		response.setContentType("image/jpeg"); 
		
		//String filePath = request.getRealPath("/WEB-INF/image/photo1.jpg"); 이 getRealPath 디플리케이트된건 되도록 쓰지마
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg");
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values) ) != -1){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close(); // OutputStream은 톰캣이 관리하기 때문에 안 닫아도 된다.
		os.close(); 
		
	}

	
}
