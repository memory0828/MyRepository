package ch08.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam07 {
	public static void main(String[] args) {
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자
			
			//내가 트랜잭션 작업을 시작하겠다(=내가 수동으로 커밋을 해서 DB 처리를 하겠다!)
			conn.setAutoCommit(false); //이걸로 업데이트나 인서트, delete등을 해도 자동으로 커밋을안햄
			
			//=====출금작업
			//String sql1 = "update account set abalance=abalance-? where ano=?"; 
							//물음포는 하나의값일때는 괜찮지만 연산식안에서는 쓸수없다
							//그래서 abalance-?에서 ?은 쓸수없다...
			String sql1 = "update account set abalance=abalance-10000 where ano='111-111";
			PreparedStatement pstmt1= conn.prepareStatement(sql1);
			int rowNo1 = pstmt1.executeUpdate();
			pstmt1.close();
			
			//=====입금작업
			String sql2 = "update account set abalance=abalance+10000 where ano='111-113";
			PreparedStatement pstmt2= conn.prepareStatement(sql2);
			int rowNo2 = pstmt2.executeUpdate();
			pstmt2.close();
			
			if(rowNo1 ==1 && rowNo2 == 1){ //값이 1이라는건 성공적으로 실행했따는 이야기(1이상의 값은 나오지 않도록 설계했다면)
				conn.commit(); //DB에 반영함
				System.out.println("계좌이체 성공함");
			}else{
				conn.rollback(); //DB에 반영하던거 취소
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

