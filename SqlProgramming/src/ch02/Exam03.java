package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam03 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자

		String sql = "select empno, ename, (sal*12+nvl(comm,0)) as yearsal from emp";
		sql += " where sal>? and deptno=?";
		sql += " order by yearsal desc";
		
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, 400);
		pstmt.setInt(2, 30); 
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			int yearsal = rs.getInt("yearsal");
			System.out.println("empno" + ":" + empno + " / "+ ename + " / " + yearsal);
		}
		
		rs.close(); pstmt.close(); conn.close();
	}
}

