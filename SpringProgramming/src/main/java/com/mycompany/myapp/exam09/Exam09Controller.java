package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09") //공통경로
public class Exam09Controller {	
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);

	//1. setter방식으로 주입 =======================
	//private B b = new B(); DI 즉 주입하려면 이렇게 생성하지 않는다
	private B b;
	public void setBxx(B b) {
		logger.info("●b 주입");		
		this.b = b;
	}
	private A a;
	public void setAxx(A a) {
		logger.info("●a 주입");		
		this.a = a;
	}
	private ServiceA serviceA;
	public void setServiceAxx(ServiceA serviceA){
		logger.info("●serviceA 주입");	
		this.serviceA = serviceA;
	}
	private ServiceB serviceB;
	public void setServiceBxx(ServiceB serviceB){
		logger.info("●serviceB 주입");	
		this.serviceB = serviceB;
	}	
	//인터페이스 사용
	private ServiceC serviceC;
	public void setServiceCxx(ServiceC serviceC){
		logger.info("●serviceC를 구현한 구현객체 주입");	
		this.serviceC = serviceC;
	}	
	private ServiceD serviceD;
	public void setServiceDxx(ServiceD serviceD){
		logger.info("●serviceD를 구현한 구현객체 주입");	
		this.serviceD = serviceD;
	}			
	//======================================
	
	
	public Exam09Controller(){
		logger.info("●Exam09Controller()객체 생성");
	}


	//세부경로
	@RequestMapping("/index")
	public String index(){
		logger.info("=========== index 요청처리");
		return "exam09/index";
	}

	@RequestMapping("/method1")
	public String method1(){
		logger.info("=========== method1 요청처리");
		b.method();
		a.method();
		serviceA.method();
		serviceB.method();
		serviceC.method();
		serviceD.method();
		return "redirect:/exam09/index";
	}
	
}