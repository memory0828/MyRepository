package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.PhotoBoard;

public class PhotoBoardService {
	private static final int WRITE_SUCESS = 0;
	private static final int WRITE_FAIL = 1;
	
	private static final int MODIFY_SUCESS = 0;
	private static final int MODIFY_FAIL = 1;

	private static final int REMOVE_SUCESS = 0;
	private static final int REMOVE_FAIL = 1;
	
	@Autowired
	private PhotoBoardDao photoBoardDao;
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return photoBoardDao.selectByPage(pageNo, rowsPerPage);
	}
	
	public int write(PhotoBoard freeBoard){
		int row = photoBoardDao.insert(freeBoard);
		return WRITE_SUCESS;
	}

	public int modify(PhotoBoard freeBoard){
		int row = photoBoardDao.update(freeBoard);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCESS;
	}
	
	public int remove(int bno){
		int row = photoBoardDao.delete(bno);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public PhotoBoard info(int bno){
		return photoBoardDao.selectByBno(bno);
	}
}
