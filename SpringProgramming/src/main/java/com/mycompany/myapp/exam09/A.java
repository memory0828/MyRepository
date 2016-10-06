package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A {	
	private static final Logger logger = LoggerFactory.getLogger(A.class);
	public A(){
		logger.info("●A()객체 생성");
	}
	
	public void method(){
		logger.info("●A의 method 요청처리");
	}
}