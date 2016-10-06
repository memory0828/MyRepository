package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImple1 implements ServiceD {
	private static final Logger logger = LoggerFactory.getLogger(ServiceDImple1.class);
	
	public ServiceDImple1(){
		logger.info("●ServiceD를 구현한 ServiceDImple1()객체 생성");
	}
	@Override
	public void method() {
		logger.info("●ServiceD를 구현한 ServiceD를 method 요청처리");
	}
}
