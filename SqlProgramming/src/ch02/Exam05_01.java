package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam05_01 {
	public static void main(String[] args) throws Exception {
		//내가 만든 코드
		Scanner sc = new Scanner( System.in );
		do{
			System.out.print("검색할 이름(quit는 종료) : ");
			String inputStr = sc.nextLine().toLowerCase();
			
			if(inputStr.equals("quit")){
					System.out.println("==■프로그램 종료");
					break;
			}
			
			String findName = "%" + inputStr +"%";			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "kosa12345"); //1번방식으로 쓰자
			String sql = "select EMPLOYEE_ID,FIRST_NAME from employees where lower(FIRST_NAME) like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, findName);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next() == false)
				System.out.println("==■검색 이름이 없음");
			else{
				do{
					int id = rs.getInt("EMPLOYEE_ID");
					String fn = rs.getString("FIRST_NAME");
					System.out.println(id + ":"+ fn);
				}while(rs.next());
			}
			rs.close(); pstmt.close(); conn.close();
			
		}while(true);
		
	}
}

