package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E {	
	private static final Logger logger = LoggerFactory.getLogger(E.class);
	private B b;
	private D d;
	
	public E(B b, D d){
		logger.info("●E(B b, D d)객체 생성과 Constructor 이용해서 주입");
		this.b = b;
		this.d = d;
	}
	
	public void method(){
		logger.info("●E의 method 실행");
		b.method();
		d.method();
	}
	
}