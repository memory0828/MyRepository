package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class I {	
	private static final Logger logger = LoggerFactory.getLogger(I.class);
	private H h;
	
	@Autowired //생성자에다가도 이거 불일 수 있음
	public I(H h){
		logger.info("●I()객체 생성");
		this.h = h;
	}
	
	public void method(){
		logger.info("●I의 method 실행");
		h.method();
	}
}