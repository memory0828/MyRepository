package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component 이걸 통해 관리객체가 되는것
@Component
public class H {	
	private static final Logger logger = LoggerFactory.getLogger(H.class);
	
	public H(){
		logger.info("●H()객체 생성");
	}
	
	public void method(){
		logger.info("●H의 method 실행");

	}
}