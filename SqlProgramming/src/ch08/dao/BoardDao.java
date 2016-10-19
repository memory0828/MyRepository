package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;

public class BoardDao {

	public void insert(Board board) {
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "insert into BOARD(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime()));//java.util의 Date가 아닌 java.sql의 Date로 씀(디플리케이트 되었지만 걍 씀!)
			//ResultSet rs = pstmt.executeQuery(); //그동안 썼던 executeQuery() 이건 데이터를 조회할 select때만 씀
			int rowNo = pstmt.executeUpdate(); //데이터의 조작을 할 때 사용(변경, 수정, 삭제)
			if(rowNo == 1){
				System.out.println("저장 성공");
			}
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("저장 실패");
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
	}
	
	
	public void update(Board board) {
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "update BOARD set bhitcount=?, bdate=? where bno=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getBhitcount());
			pstmt.setDate(2, new Date(board.getBdate().getTime()));//java.util의 Date가 아닌 java.sql의 Date로 씀(디플리케이트 되었지만 걍 씀!)
			pstmt.setInt(3, board.getBno());
			
			//ResultSet rs = pstmt.executeQuery(); //그동안 썼던 executeQuery() 이건 데이터를 조회할 select때만 씀
			int rowNo = pstmt.executeUpdate(); //데이터의 조작을 할 때 사용(변경, 수정, 삭제)
				//경우1 - 1 이상의 값(1개 이상의 행이 수정됨)
				//경우2 - 0 어떤행도 수정되지 않음
				//경우3 - 예외(문법오류)
			if(rowNo >= 1){
				System.out.println(rowNo + "개의 행이 수정됨");
			}else if(rowNo == 0){
				System.out.println("수정된 행이 없음");
			}
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void deleteByBno(int bno){
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자			
			String sql = "delete BOARD where bno=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			//ResultSet rs = pstmt.executeQuery(); //그동안 썼던 executeQuery() 이건 데이터를 조회할 select때만 씀
			int rowNo = pstmt.executeUpdate(); //데이터의 조작을 할 때 사용(변경, 수정, 삭제)
				//경우1 - 1 이상의 값(1개 이상의 행이 수정됨)
				//경우2 - 0 어떤행도 수정되지 않음
				//경우3 - 예외(문법오류)
			if(rowNo >= 1){
				System.out.println(rowNo + "개의 행이 지워짐");
			}else if(rowNo == 0){
				System.out.println("지워진 행이 없음");
			}
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
	}
}
