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
	
	//2. Constructor 이용해서 주입 =======================	
	private C c;
	/*
	public Exam09Controller(C c){ .. } 
	이렇게 생성자를 통해받는건 자바 문법상으로 아무 문제가 없지만
	스프링에서 @Controller로 지정된 컨트롤러는 기본 생성자만 허용하기 때문에
	이대로 하면 예외가 발생함 그래서 결론은 반드시 기본생성자야함
	그래서 어쩔수없이 Setter주입만 허용된다.
	*/
	//c는 인수 1개짜리
	public void setCxx(C c){
		logger.info("● : c 주입 ( C에서 Constructor 이용해서 D 주입되 있음 )");	
		this.c = c;
	}
	
	//e는 인수 2개짜리
	private E e;
	public void setExx(E e){
		logger.info("● : e 주입 ( E에서 Constructor 이용해서 B와 D가 주입되 있음 ) ");	
		this.e = e;
	}	
	
	//f는 인수 3개짜리인데 한개는 인터페이스
	private F f;
	public void setFxx(F f){
		logger.info("● : f 주입 ( F에서 Constructor 이용해서 ServiceA, ServiceB, ServiceC(인터페이스)가 주입되 있음 ) ");	
		this.f = f;
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
	
	@RequestMapping("/method2")
	public String method2(){
		logger.info("=========== method2 요청처리");
		c.method();
		e.method();
		f.method();
		return "redirect:/exam09/index";
	}
	
}