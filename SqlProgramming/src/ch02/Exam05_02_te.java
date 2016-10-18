package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exam05_02_te {
	public static void main(String[] args) {
		//선생님께서 만드신 코드
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Scanner sc = new Scanner( System.in );
			while(true){
				System.out.print("검색할 이름 : ");
				String inputStr = sc.nextLine().toLowerCase();
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "kosa12345"); //1번방식으로 쓰자			
				String sql = "select EMPLOYEE_ID,FIRST_NAME from employees where lower(FIRST_NAME) like ?";
				PreparedStatement pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, "%" + inputStr +"%");
				ResultSet rs = pstmt.executeQuery();
				if(rs.next() == false)
					System.out.println("==■검색 이름이 없음");
				else{
					do{
						String id = rs.getString("EMPLOYEE_ID");
						String fn = rs.getString("FIRST_NAME");
						System.out.println(id + ":"+ fn);
					}while(rs.next());
				}				
				rs.close(); pstmt.close(); conn.close();
			}
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		
	}
}

