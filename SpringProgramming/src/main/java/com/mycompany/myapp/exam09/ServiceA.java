package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

public class ServiceA {
	private static final Logger logger = LoggerFactory.getLogger(ServiceA.class);
	
	public ServiceA(){
		logger.info("●ServiceA()객체 생성");
	}
	public void method(){
		logger.info("●ServiceA의 method 요청처리");
	}
}
