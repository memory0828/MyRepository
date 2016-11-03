package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.FreeBoardService;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@Autowired
	private PhotoBoardService photoBoardService;
	
	@RequestMapping("/")
	public String home(Model model, HttpSession session) {
		int intTextBoardPageNo = 1;
		int rowsTextBoardPerPage = 5;
		
		List<FreeBoard> list1 = freeBoardService.list(intTextBoardPageNo, rowsTextBoardPerPage);
		model.addAttribute("indexlist1", list1);
		
		int intPhotoBoardPageNo = 1;
		int rowsPhotoBoardPerPage = 4;
		List<PhotoBoard> list2 = photoBoardService.list(intPhotoBoardPageNo, rowsPhotoBoardPerPage);
		model.addAttribute("indexlist2", list2);
		
		return "home";
	}

	
}
