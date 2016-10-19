package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Member;

public class MemberDao {
	private Connection conn;
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Member member) throws SQLException{
		String sql = "insert into member(mid, mname, mage, mbirth) values(?, ?, ?, ?)";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setInt(3, member.getMage());			
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public Member selectByMid(String mid) throws SQLException{
		String sql = "select mid, mname, mage, mbirth from MEMBER where mid=?";
		Member member=null;
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			member = new Member();
			member.setMid(rs.getString("MID"));
			member.setMname(rs.getString("MNAME"));
			member.setMage(rs.getInt("MAGE"));
			member.setMbirth(rs.getDate("MBIRTH"));
		}
		rs.close();
		pstmt.close();
		return member;
	}

	public List<Member> selectByMname(String mname) throws SQLException{
		String sql = "select mid, mname, mage, mbirth from member where mname like ?";
		List<Member> list = new ArrayList<>(); //null을 안쓰는 이유는 보통 비어있는 리스트라도 리턴하도록 함(null로 리턴하면 for문돌릴때 null체크를해야함)
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, "%" + mname + "%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Member member = new Member();
			member.setMid(rs.getString("MID"));
			member.setMname(rs.getString("MNAME"));
			member.setMage(rs.getInt("MAGE"));
			member.setMbirth(rs.getDate("MBIRTH"));
			list.add(member);
		}
		rs.close();
		pstmt.close();
		return list;
	}

	public int update(Member member) throws SQLException{
		String sql = "update member set mname=?, mage=?, mbirth=? where mid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, member.getMname());
		pstmt.setInt(2, member.getMage());			
		pstmt.setDate(3, new Date(member.getMbirth().getTime()));
		pstmt.setString(4, member.getMid());
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByMid(String mid) throws SQLException{
		String sql = "delete member where mid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	
}
