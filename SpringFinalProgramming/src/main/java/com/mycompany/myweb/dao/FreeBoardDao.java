package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeboard){
		String sql = "insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextval,?,?,?,0, sysdate)";
		int row = jdbcTemplate.update(
			sql,
			freeboard.getBtitle(),
			freeboard.getBcontent(),
			freeboard.getBwriter()			
		);
		return row;
	}
	
	public int update(FreeBoard freeboard){
		String sql = "update freeboard set btitle=?, bcontent=?, bhitcount=? where bno=?";
		int row = jdbcTemplate.update(
			sql,
			freeboard.getBtitle(),
			freeboard.getBcontent(),
			freeboard.getBhitcount(),			
			freeboard.getBno()
		);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from freeboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}

	public FreeBoard selectByMid(String mid){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{mid},
				new RowMapper<FreeBoard>(){
					@Override
					public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
						FreeBoard freeboard = new FreeBoard();
						freeboard.setBno(rs.getInt("bno"));
						freeboard.setBtitle(rs.getString("btitle"));
						freeboard.setBcontent(rs.getString("bcontent"));
						freeboard.setBwriter(rs.getString("bwriter"));
						freeboard.setBhitcount(rs.getInt("bhitcount"));
						freeboard.setBdate(rs.getDate("bdate"));
						return freeboard;
					}
		} );
		return (list.size() !=0)?list.get(0):null;
	}
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		sql += "select rn, bno, btitle, bwriter, bhitcount, bdate";
		sql += " from (";
		sql += " select rownum as rn, bno, btitle, bwriter, bhitcount, bdate";
		sql += " from (select bno, btitle, bwriter, bhitcount, bdate from freeboard order by bno desc)";
		sql += " where rownum<=?";
		sql += " )";
		sql += " where rn>=?";
		List<FreeBoard> list = jdbcTemplate.query(
				sql,
				new Object[]{  (pageNo * rowsPerPage),   ((pageNo-1)*rowsPerPage+1) },
				new RowMapper<FreeBoard>(){
					@Override
					public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
						FreeBoard freeboard = new FreeBoard();
						freeboard.setBno(rs.getInt("bno"));
						freeboard.setBtitle(rs.getString("btitle"));
						freeboard.setBwriter(rs.getString("bwriter"));
						freeboard.setBhitcount(rs.getInt("bhitcount"));
						freeboard.setBdate(rs.getDate("bdate"));
						return freeboard;
					}
		} );
		return list;
	}
	
	public int count() {
		String sql="select count(*) from freeboard";
		//.queryForObject는
		//이거를 실행하고 나서 하나의 객체를 리턴함(무조건 한개의 행을 가져온다는 보장이 있으면 쓰는것)
		//만약에 하나의 행을 가져오지 않으면 예외가 발생함 그러니. 반드시 sql문에 의해서 하나의 값이 와야만이 이것을 쓸수있다
		//여기서 queryForObject(sql, Integer.class );의 Integer.class 로 반환값 타입을 결정함
		int count = jdbcTemplate.queryForObject(sql, Integer.class ); 
		return count;
		
	}
}







