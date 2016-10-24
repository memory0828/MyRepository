package com.mycompany.myapp.exam12.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dao.MemberDao;
import com.mycompany.myapp.exam12.dto.Member;


@Component
public class Exam12Service {
	private static final Logger logger = LoggerFactory.getLogger(Exam12Service.class);

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberDao dao; //주입받기
	//주입을 받아 쓰냐 안쓰냐는 어떤 한 메소드에서만 사용할경우에는 주입필요가없지만
	//여러 메소드에서 쓸거면 주입을 통해 사용한다
	
	public void join(Member member) {
		Connection conn = null;
		try {
			//그동안은 이렇게 바로 커넥션을 만들었는데, 이제는 하지말자!
			//Class.forName("oracle.jdbc.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			conn = dataSource.getConnection(); //대여
			dao.setConn(conn);
			int rowNo = dao.insert(member);
			logger.info(rowNo + "행이 저장됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); //★커넥션을 사용할떄 close는 연결을 끊는다가 아니라, 반납의 의미다! 
			} catch (SQLException e) { }
		}
		
	}

}
