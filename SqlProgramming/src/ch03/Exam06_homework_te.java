package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam06_homework_te {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//선생님이 만드신 소스
		Employee emp = getEmployee(1001);
		System.out.println(emp.getEmpno() + ":" + emp.getEname() + ":" + emp.getSal());

		List<Department> result = getDepartment("개발");
		for(Department dept : result){
			System.out.println(dept.getDeptno()+ ":" + dept.getDname() + ":" + dept.getLoc());
		}	
		
	}
	/*
	private static Employee getEmployee(int searchEmpno) {
		Employee emp = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from EMP where EMPNO like ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchEmpno + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e){			
			try { conn.close(); } catch (SQLException e2) {}
		}			
		
		return emp;

		
	}
	*/
	
	private static Employee getEmployee(int searchEmpno) {
		String sql = "select * from emp where empno=? ";
		Connection conn = null;		//Connection conn; 선언만하면 메모리에 생성안되고 초기화 에러가 난다
		Employee employee = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				employee = new Employee();
				employee.setEmpno(rs.getInt("empno"));
				employee.setEname(rs.getString("ename"));
				employee.setJob(rs.getString("job"));
				employee.setMgr(rs.getInt("mgr"));
				employee.setHiredate(rs.getDate("hiredate"));
				employee.setSal(rs.getDouble("sal"));
				employee.setComm(rs.getDouble("comm"));
				employee.setDeptno(rs.getInt("deptno"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try { conn.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		return employee;
	}
	/*
	private static List<Department> getDepartment(String searchDname) {
		List<Department> list = new ArrayList<>();
		Department dpt = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from dept where dname like ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchDname + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				dpt = new Department();
				dpt.setDeptno(rs.getInt("deptno"));
				dpt.setDname(rs.getString("dname"));
				dpt.setLoc(rs.getString("loc"));
				list.add(dpt);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e){			
			try { conn.close(); } catch (SQLException e2) {}
			e.printStackTrace();
		}

		
		return list;
	}
	*/
	private static List<Department> getDepartment(String searchDname) {
		List<Department> list = new ArrayList<>();		//리스트를 리턴할때 널을 리턴하지않고 비어있는 어레이리스트를 리턴한다.
		String sql = "select * from dept where dname like ? ";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchDname + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
		return list;
	}
	
}
