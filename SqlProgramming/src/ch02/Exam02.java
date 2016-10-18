package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자

		//매개변수화된 SQL문 사용
		//String sql = "select * from emp where ename like '%성%'"; 이렇게 쓰기보다 아래처럼 매개변수화 시켜서 쓴다 
		String sql = "select * from emp where ename like ?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		//?가 뭔지 알려주는 과정
		pstmt.setString(1, "%성%"); //1번인덱스(제일처음?의 의미)인 ?에 해당하는 곳에 "%성%"를 넣는것
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			//rs.getXXX... XXX... 은 내가 얻고 싶은 데이터의 형태
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			System.out.println("empno" + ":" + empno + " / "+ ename);
		}
		
		rs.close(); pstmt.close(); conn.close();
	}
}

