package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

public class ServiceB {
	private static final Logger logger = LoggerFactory.getLogger(ServiceB.class);
	
	public ServiceB(){
		logger.info("●ServiceB()객체 생성");
	}
	public void method(){
		logger.info("●ServiceB의 method 실행");
	}
}
