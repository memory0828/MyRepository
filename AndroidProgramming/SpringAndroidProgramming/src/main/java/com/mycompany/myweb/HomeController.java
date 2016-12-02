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
import com.mycompany.myweb.dto.Food;

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
        list.add(new Light("light1.png", "light1_large.png", "밀라비 1등/2등 펜던트", "반투명 크롬 유리 갓의 아늑함!"));
        list.add(new Light("light2.png", "light2_large.png", "프리펠 4등 직부", "유니크한 사다리꼴, 세련된 철제라인!"));
        list.add(new Light("light3.png", "light3_large.png", "비플럼 레일 1M 3구 세트", "유쾌함이 가득한 모던한 레일!"));
        list.add(new Light("light4.png", "light4_large.png", "빔 LED 벽등", "빛의 각도를 좁게, 또는 넓게!"));
        list.add(new Light("light5.png", "light5_large.png", "스텔드 파이프 2등 장스탠드", "빈티지한 인테리어를 찾으신다면!"));
        list.add(new Light("light1.png", "light1_large.png", "밀라비 1등/2등 펜던트", "반투명 크롬 유리 갓의 아늑함!"));
        list.add(new Light("light2.png", "light2_large.png", "프리펠 4등 직부", "유니크한 사다리꼴, 세련된 철제라인!"));
        list.add(new Light("light3.png", "light3_large.png", "비플럼 레일 1M 3구 세트", "유쾌함이 가득한 모던한 레일!"));
        list.add(new Light("light4.png", "light4_large.png", "빔 LED 벽등", "빛의 각도를 좁게, 또는 넓게!"));
        list.add(new Light("light5.png", "light5_large.png", "스텔드 파이프 2등 장스탠드", "빈티지한 인테리어를 찾으신다면!"));        
		model.addAttribute("list", list); //el에 객체등록
		return "lightList";
	}
	
	@RequestMapping("/foodlist")
	public String foodlist(Model model) {
		logger.info("■CTL■ foodlist 페이지 호출");
		
		List<Food> list = new ArrayList<>();
        list.add(new Food("food01.png", "food01_large.png", "레인지랜드 립레츠", "15,500", "매콤달콤한 바비큐 소스를 바른 돼지갈비 요리"));
        list.add(new Food("food02.png", "food02_large.png", "스파이시 비프 퀘사디아 ", "16,900", "비프와 야채를 그릴에 볶아 치즈와 함께 또띠아에 넣어 구운 퀘사디아"));
        list.add(new Food("food03.png", "food03_large.png", "골드 코스트 코코넛 쉬림프 ", "20,000", "달콤하고 고소한 코코넛 가루를 묻혀 바삭하게 튀긴 새우요리"));
        list.add(new Food("food04.png", "food04_large.png", "기브미 파이브", "31,900", "인기 애피타이저 5종을 맛볼 수 있는 플래터"));
        list.add(new Food("food05.png", "food05_large.png", "크리스피 쿠카부라 윙 ", "16,500", "아웃백 시즈닝으로 바삭하고 특별한 맛을 즐길 수 있는 닭날개 요리"));
        list.add(new Food("food01.png", "food01_large.png", "오지 치즈 후라이즈 ", "18,900", "두툼한 감자튀김에 체다치즈, 잭치즈를 듬뿍 녹여 베이컨을 뿌린 메뉴"));
        list.add(new Food("food02.png", "food02_large.png", "베이비 백 립", "33,500", "부드러운 어린 돼지갈비에 아웃백만의 특제 소스를 발라 구워낸 바비큐 요리."));
        list.add(new Food("food03.png", "food03_large.png", "베이비 백 립 (550g)", "39,500", "부드러운 어린 돼지갈비에 아웃백만의 특제 소스를 발라 구워낸 바비큐 요리."));
        list.add(new Food("food04.png", "food04_large.png", "앨리스 스프링 치킨", "22,500", "구운 닭가슴살에 베이컨, 잭치즈, 체다치즈를 올려 오븐에 구운 요리"));
        list.add(new Food("food05.png", "food05_large.png", "카카두 그릴러", "23,500", "갈비양념에 재워 그릴에서 볶아낸 슬라이스 비프요리"));
		model.addAttribute("list", list); //el에 객체등록
		return "foodList";
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
