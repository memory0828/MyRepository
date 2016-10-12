package com.mycompany.myapp.exam10;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam10") //공통경로
public class Exam10Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);

	//======================================
	//어노테이션 이용한 1. setter방식으로 주입
	private G g;	
	@Autowired //관리객체 들중에서 G가 있으면 자동으로 대입(넣어)해 주겠다
	/*
	일단 g가 관리객체가 되야하니깐 G클래스에서 @Component를 붙여넣고
	이걸통해서 관리객체가 되게 만들어놓고
	이 @Autowired로 지정된 곳을 찾아서 
	만약에 g라는 객체가 대입될 필요성이 있으면 자동으로 대입된다.
	*/	
	public void setG(G g){
		logger.info("●setG(G g) - g 주입(@Autowired 이용)");
		this.g = g;
	}
	
	private H h;	
	@Autowired
	public void setH(H h){
		logger.info("●setH(H h) - h 주입(@Autowired 이용)");
		this.h = h;
	}
	
	private Service service;
	/*@Autowired
	public void setService(Service service){
		logger.info("●setService(Service service) - Service를 구현한 객체 주입(@Autowired 이용)");
		this.service = service;
	}*/
	/*위 @Autowired는 Service인터페이스로 구현한 클래스는 2가지가 있는데, 그중 하나인에만
	ServiceImpl1에만 @Component을 붙여서
	사용할수있었다. 근데 2개를 다 사용하려면 @Autowired가 아닌 다른방법을 찾아야하함
	그게 @Resource이다 
	@Autowired --> Type으로 주입(하기때문에 해당 TYPE은 딱하나만있어야하고)
	@Resource --> 등록이름으로 주입(하기때문에 두개 있어도 쓸수있음)
	그래서 
	Service인터페이스로 구현한 클래스는 2가지에 다 모두 @Component를 붙이고
	아래처럼 변형해야한다
	*/
	//스프링책(111p 5.3)의 내용
	@Resource(name="serviceImpl2") //serviceImpl2는 첫자를 소문자로 한 이름으로 관리객체로 등록되기 때문에 이렇게 이름사용
	public void setService(Service service){
		logger.info("●setService(Service service) - Service를 구현한 2개의 객체중 하나 주입(@Resource 이용)");
		this.service = service;
	}
	
	//======================================
	//어노테이션 이용한 2. 생성자 방식으로 주입
	private I i;	
	@Autowired
	public void setI(I i){
		logger.info("●setI(I i) - i 주입(@Autowired 이용)");
		this.i = i;
	}	

	private J j;	
	@Autowired
	public void setI(J j){
		logger.info("●setI(J j) - J 주입(@Autowired 이용)");
		this.j = j;
	}	

	//======================================
	//어노테이션 이용한 3. Field 주입
	@Autowired
	private K k;
	//이거??? 겁나 편리하지만 그전껄 다 알고 있어야한다~ 그래서 배운다
	//======================================
	
	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam10/index";
	}

	@RequestMapping("/method1")
	public String method1(){
		logger.info("=========== method1 요청처리");
		g.method();
		h.method();
		service.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method2")
	public String method2(){
		logger.info("=========== method2 요청처리");
		i.method();
		j.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method3")
	public String method3(){
		logger.info("=========== method3 요청처리");
		k.method();
		return "redirect:/exam10/index";
	}
}