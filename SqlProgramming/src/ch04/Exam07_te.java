package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam07_te {

	public static void main(String[] args) {
		List<JobSalary> result = getMethod("사원",1000);
		for(JobSalary js : result){
			System.out.println(js.getJob()+ ":" + js.getSalary());
		}
 
	}
	
	private static List<JobSalary> getMethod(String Job,int Salary){
		List<JobSalary> list = new ArrayList<>();
		String sql = "";
				sql += "select job,sum(sal) as salary ";
				sql += "from emp where job<>? ";
				sql += "group by job ";
				sql += "having sum(sal)>=? ";
				sql += "order by salary ";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Job);
			pstmt.setInt(2, Salary);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				JobSalary js = new JobSalary();
				js.setJob(rs.getString("job"));
				js.setSalary(rs.getInt("salary"));
				list.add(js);
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
