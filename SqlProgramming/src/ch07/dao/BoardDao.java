package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Board;
import ch07.dto.Member;

public class BoardDao {

	public Board selectByMid(int searchMid) {
		Board b = new Board();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from Board where BNO like ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, searchMid);
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next() == false){
				b = null;
			}else{
				b.setBno(rs.getInt("BNO"));
				b.setBtitle(rs.getString("BTITLE"));
				b.setBcontent(rs.getString("BCONTENT"));
				b.setBwriter(rs.getString("BWRITER"));
				b.setBhitcount(rs.getInt("BHITCOUNT"));
				b.setBdate(rs.getDate("BDATE"));
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return b;
	}
	
	public List<Board> selectAll() {		
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "select * from Board";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//pstmt.setString(1, searchMid);
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next() == false){
				list = null;
			}else{
				do{
				Board b = new Board();
				b.setBno(rs.getInt("BNO"));
				b.setBtitle(rs.getString("BTITLE"));
				b.setBcontent(rs.getString("BCONTENT"));
				b.setBwriter(rs.getString("BWRITER"));
				b.setBhitcount(rs.getInt("BHITCOUNT"));
				b.setBdate(rs.getDate("BDATE"));
				list.add(b);
				}while(rs.next());
			}
			rs.close(); pstmt.close(); conn.close();
			
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {} //예외가 없어도 반드시 어떤경우에서도 실행되겠금
		}
		return list;
		
	}

}
