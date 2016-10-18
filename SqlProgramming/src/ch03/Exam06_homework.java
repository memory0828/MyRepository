package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam06_homework {
	public static void main(String[] args) {
		
		//1번 ---------------------------------------------------------------------------------------
		Employee emp = getEmployee(1001);
		if(emp==null){
			System.out.println("●1번 데이터 없음"); 
		}else{
			System.out.println(emp.getEmpno() + ":" + emp.getEname() + ":" + emp.getSal());
		}

		//2번 ---------------------------------------------------------------------------------------
		List<Department> result = getDepartment("개발");
		if(result==null) System.out.println("●2번 데이터 없음");
		else{
			for(Department dept : result){
				System.out.println(dept.getDeptno() + ":" + dept.getDname() + ":" + dept.getLoc());
			}
		}

	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static Employee getEmployee(int searchEmpno) {
		Employee emp = new Employee();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from emp where EMPNO like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchEmpno +"%");
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next() == false){
				emp = null;
			}else{
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setMgr(rs.getInt("MGR"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getDouble("SAL"));
				emp.setComm(rs.getDouble("COMM"));
				emp.setDeptno(rs.getDouble("DEPTNO"));
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return emp;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static List<Department> getDepartment(String searchDname) {
		List<Department> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from DEPT where DNAME like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchDname +"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == false){
				list = null;
			}else{
				do{
					Department dp= new Department();
					dp.setDeptno(rs.getInt("DEPTNO"));
					dp.setDname(rs.getString("DNAME"));
					dp.setLoc(rs.getString("LOC"));
					list.add(dp);
				}while(rs.next());
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return list;		
	}
}

