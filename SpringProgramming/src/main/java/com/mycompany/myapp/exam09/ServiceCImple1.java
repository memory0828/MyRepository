package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceCImple1 implements ServiceC {
	private static final Logger logger = LoggerFactory.getLogger(ServiceCImple1.class);
	
	public ServiceCImple1(){
		logger.info("●ServiceC를 구현한 ServiceCImple1()객체 생성");
	}
	@Override
	public void method() {
		logger.info("●ServiceC를 구현한 ServiceC를 method 실행");
	}
}
