package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Board;
import finalsource.dto.Member;

public class BoardDao {
	private Connection conn;
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Board board) throws SQLException{
		String sql = "insert into BOARD(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_board_bno.nextval, ?, ?, ?, 0, sysdate)";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public Board selectByBno(int bno) throws SQLException{
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from BOARD where bno=?";
		Board board=null;
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			board = new Board();
			board.setBno(rs.getInt("BNO"));
			board.setBtitle(rs.getString("BTITLE"));
			board.setBcontent(rs.getString("BCONTENT"));
			board.setBwriter(rs.getString("BWRITER"));
			board.setBhitcount(rs.getInt("BHITCOUNT"));
			board.setBdate(rs.getDate("BDATE"));
		}
		rs.close();
		pstmt.close();
		return board;
	}

	public List<Board> selectByBtitle(String btitle) throws SQLException{
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from BOARD where btitle like ?";
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, "%" + btitle + "%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("BNO"));
			board.setBtitle(rs.getString("BTITLE"));
			board.setBcontent(rs.getString("BCONTENT"));
			board.setBwriter(rs.getString("BWRITER"));
			board.setBhitcount(rs.getInt("BHITCOUNT"));
			board.setBdate(rs.getDate("BDATE"));
			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	}

	public int update(Board board) throws SQLException{
		String sql = "update BOARD set btitle=?, bcontent=?, bwriter=?, bhitcount=?, bdate=? where bno=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setInt(4, board.getBhitcount());
		pstmt.setDate(5, new Date(board.getBdate().getTime()));
		pstmt.setInt(6, board.getBno());
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByBno(int bno) throws SQLException{
		String sql = "delete from BOARD where bno=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException{
		//rownum 사용해서 페이지 나누기!
		String sql="";
		sql += "select rn, bno, btitle, bcontent, bwriter, bhitcount, bdate";
		sql += " from (";
		sql += " select rownum as rn, bno, btitle, bcontent, bwriter, bhitcount, bdate";
		sql += " from (select bno, btitle, bcontent, bwriter, bhitcount, bdate from board order by bno desc)";
		sql += " where rownum<=?";
		sql += " )";
		sql += " where rn>=?";
		/*sql += " where rownum<=(?*?)"; 위에서 이런식으로 ?을 못쓰는 이유는 연산식에는 ?을 사용할수 없기때문이다 
		  sql += " where rn>=( (?-1)*?+1 )";
		*/
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, pageNo * rowsPerPage);
		pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("BNO"));
			board.setBtitle(rs.getString("BTITLE"));
			board.setBcontent(rs.getString("BCONTENT"));
			board.setBwriter(rs.getString("BWRITER"));
			board.setBhitcount(rs.getInt("BHITCOUNT"));
			board.setBdate(rs.getDate("BDATE"));
			list.add(board);
		}
		rs.close();
		pstmt.close();

		return list;
	}
}
