package ch08.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ch08.dao.AccountDao;
import ch08.dto.Account;

public class Exam08 {
	public static void main(String[] args) {
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			//conn 즉 Connection은 하나만 사용가능하다(JDMS에서)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자
			//트렌젠션 작업을 시작
			conn.setAutoCommit(false);

			AccountDao accountDao = new AccountDao();
			accountDao.setConn(conn); //작업1과 작업2는 커넥션이 동일해야함  그래서 이렇게 넣어줌
			
			//작업1			
			Account account1 = new Account();
			account1.setAno("111-111");
			account1.setAbalance(500000);
			int rowNo1 = accountDao.update(account1);
				
			//작업2
			Account account2 = new Account();
			account2.setAno("111-113");
			account2.setAbalance(200000);
			int rowNo2 = accountDao.update(account2);
			
			if(rowNo1 ==1 && rowNo2 == 1){ 
				conn.commit();
				System.out.println("계좌이체 성공함");
			}else{
				conn.rollback();
				System.out.println("계좌가 존재하지 않아서 계좌이체 실패함");
			}
			
		} catch (Exception e1) {
			try {conn.rollback(); //예외가 발생했을 때 롤백처리
			} catch (SQLException e2) {} 
			System.out.println("예외가 발생하여 계좌이체 실패함");
		} finally {
			try {
				conn.setAutoCommit(true); //내가 사용할떄는 트랜잭션작업이 필요해서 false로 해놓았는데, 만약 다른사람이 뒤에 사용할 경우를 대비해서 원래대로 돌려놓아야함(그사람이 트랜잭션작업을 안할수도있기때문에)
				conn.close();} catch (SQLException e2) {}
		}
		
		
		
		
	}
}

