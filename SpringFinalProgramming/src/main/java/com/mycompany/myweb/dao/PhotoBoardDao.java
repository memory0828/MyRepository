package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoboard){
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextval,?,?,?,0, sysdate,?,?,?)";
		int row = jdbcTemplate.update(
			sql,
			photoboard.getBtitle(),
			photoboard.getBcontent(),
			photoboard.getBwriter(),
			photoboard.getOriginalfile(),
			photoboard.getSavedfile(),
			photoboard.getMimetype()
		);
		return row;
	}
	
	public int update(PhotoBoard photoboard){
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
		int row = jdbcTemplate.update(
			sql,
			photoboard.getBtitle(),
			photoboard.getBcontent(),
			photoboard.getBhitcount(),			
			photoboard.getOriginalfile(),
			photoboard.getSavedfile(),
			photoboard.getMimetype(),
			
			photoboard.getBno()
		);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from photoboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}

	public PhotoBoard selectByMid(String mid){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{mid},
				new RowMapper<PhotoBoard>(){
					@Override
					public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
						PhotoBoard photoboard = new PhotoBoard();
						photoboard.setBno(rs.getInt("bno"));
						photoboard.setBtitle(rs.getString("btitle"));
						photoboard.setBcontent(rs.getString("bcontent"));
						photoboard.setBwriter(rs.getString("bwriter"));
						photoboard.setBhitcount(rs.getInt("bhitcount"));
						photoboard.setBdate(rs.getDate("bdate"));
						photoboard.setOriginalfile(rs.getString("originalfile"));
						photoboard.setSavedfile(rs.getString("savedfile"));
						photoboard.setMimetype(rs.getString("mimetype"));
						return photoboard;
					}
		} );
		return (list.size() !=0)?list.get(0):null;
	}
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		sql += "select rn, bno, btitle, bhitcount, savedfile";
		sql += " from (";
		sql += " select rownum as rn, bno, btitle, bhitcount, savedfile";
		sql += " from (select bno, btitle, bhitcount, savedfile from photoboard order by bno desc)";
		sql += " where rownum<=?";
		sql += " )";
		sql += " where rn>=?";
		List<PhotoBoard> list = jdbcTemplate.query(
				sql,
				new Object[]{  (pageNo * rowsPerPage),   ((pageNo-1)*rowsPerPage+1) },
				new RowMapper<PhotoBoard>(){
					@Override
					public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
						PhotoBoard photoboard = new PhotoBoard();
						photoboard.setBno(rs.getInt("bno"));
						photoboard.setBtitle(rs.getString("btitle"));
						photoboard.setBhitcount(rs.getInt("bhitcount"));
						photoboard.setSavedfile(rs.getString("savedfile"));
						return photoboard;
					}
		} );
		return list;
	}
	
	public int count() {
		String sql="select count(*) from photoboard";
		//.queryForObject는
		//이거를 실행하고 나서 하나의 객체를 리턴함(무조건 한개의 행을 가져온다는 보장이 있으면 쓰는것)
		//만약에 하나의 행을 가져오지 않으면 예외가 발생함 그러니. 반드시 sql문에 의해서 하나의 값이 와야만이 이것을 쓸수있다
		//여기서 queryForObject(sql, Integer.class );의 Integer.class 로 반환값 타입을 결정함
		int count = jdbcTemplate.queryForObject(sql, Integer.class ); 
		return count;
		
	}
}