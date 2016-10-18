package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam05_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		while(true){
			System.out.print("검색할 이름 : ");
			String inputStr = sc.nextLine().toLowerCase();
			List<Employee> result = getList(inputStr);
			for(Employee em : result){
				System.out.println(em.getEmpno() + ":" + em.getEname());
			}

		}
	}
	
	public static List<Employee> getList(String searchName){
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from emp where ENAME like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName +"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setMgr(rs.getInt("MGR"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getDouble("SAL"));
				emp.setComm(rs.getDouble("COMM"));
				emp.setDeptno(rs.getDouble("DEPTNO"));
				list.add(emp);
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}

		return list;
	}
}

