package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;

@Controller
//@ SessionAttributes("pageNo")
//@ SessionAttributes("list") 내가 세션에 저장되도록 이름을 하겠다 힌트주는거
//그럼 모델의 add어튜리뷰트는 list에 한에 세션에 저장한다
@RequestMapping("/freeboard")
public class FreeBoardController {
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){
		//public String list(@ModelAttribute("pageNo") String pageNo, Model model, HttpSession session){
		//@ModelAttribute("pageNo") pageNo이 이름이 있는 세션이나 리퀘스트에서 값을 가져옴
		//근데 기본은 리퀘스트고 위에 @SessionAttributes("pageNo")이렇게 선언되어 있으면 세션에서 가져옴 
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = freeBoardService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		return "freeboard/list";
			
	}
	

	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard, HttpSession session){
		String mid = (String)session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if(result == FreeBoardService.WRITE_FAIL){
			return "freeboard/write";
		}else{
			return "redirect:/freeboard/list";
		}
	}
	
	@RequestMapping("info")
	public String info(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount() + 1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/info";
	}

	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyForm(FreeBoard freeBoard){
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	}
	

	@RequestMapping("/remove")
	public String remove(int bno){
		freeBoardService.remove(bno);
		return "redirect:/freeboard/list";
	}

	
}
