package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Member;

public class MemberDao {

	public Member selectByMid(String searchMid) {
		Member m = new Member();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from MEMBER where MID like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, searchMid);
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next() == false){
				m = null;
			}else{
				m.setMid(rs.getString("MID"));
				m.setMname(rs.getString("MNAME"));
				m.setMage(rs.getInt("MAGE"));
				m.setMbirth(rs.getDate("MBIRTH"));
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return m;
	}
	
	public List<Member> selectAll() {		
		List<Member> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from MEMBER";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//pstmt.setString(1, searchMid);
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next() == false){
				list = null;
			}else{
				do{
				Member m = new Member();
				m.setMid(rs.getString("MID"));
				m.setMname(rs.getString("MNAME"));
				m.setMage(rs.getInt("MAGE"));
				m.setMbirth(rs.getDate("MBIRTH"));
				list.add(m);
				}while(rs.next());
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return list;
		
	}
}
