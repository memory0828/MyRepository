package com.mycompany.myweb;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Light;

@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		logger.info("■CTL■ / 페이지 호출");
		return "index";
	}
	
	@RequestMapping("/lightlist")
	public String lightlist(Model model) {
		logger.info("■CTL■ lightlist 페이지 호출");
		
		List<Light> list = new ArrayList<>();
        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "거실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "욕실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "현관 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "서재 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "큰방 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "작은방 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "외부 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "거실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "욕실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "현관 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
		model.addAttribute("list", list); //el에 객체등록
		return "lightList";
	}
	
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request, HttpServletResponse response) {
		//직접응답을 보냈기 때문에 jsp로 갈필요가없어서 void 이다
		try{
			String mimeType = request.getServletContext().getMimeType(fileName); //()안의 파일의 확장명을보고 mime타입을 돌려줌
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			String filePath = request.getServletContext().getRealPath("/resources/image/" + fileName);				
			InputStream is = new FileInputStream(filePath);
			byte[] values = new byte[1024];
			int byteNum = -1;
			while( (byteNum = is.read(values))!= -1 ){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
