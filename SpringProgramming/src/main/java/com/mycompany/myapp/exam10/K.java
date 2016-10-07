package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component 이걸 통해 관리객체가 되는것
@Component
public class K {	
	private static final Logger logger = LoggerFactory.getLogger(K.class);
	
	@Autowired
	private G g;
	@Autowired
	private H h;
	
	public K(){
		logger.info("●K()객체 생성");
	}
	
	public void method(){
		logger.info("●K의 method 실행");
		g.method();
		h.method();

	}
}