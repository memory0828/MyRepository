package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
@RequestMapping("photoboard")
public class PhotoBoardController {
	private static final Logger logger = LoggerFactory.getLogger(PhotoBoardController.class);
	
	@Autowired
	private PhotoBoardService photoBoardService;
	
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){
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
		
		int rowsPerPage = 15;
		int pagesPerGroup = 5;
		
		int totalBoardNo = photoBoardService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
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
		return "photoboard/list";
			
	}

/*	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String write(){
		return "photoboard/write";
	}*/

	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard, HttpSession session){
		try{
			String mid = (String)session.getAttribute("login");
			photoBoard.setBwriter(mid);
			if(photoBoard.getPhoto().getOriginalFilename() != ""){
				//첨부파일을 넣을 경우
				photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
				String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
				String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile); //저장할 파일의 절대 파일 시스템 경로
				photoBoard.getPhoto().transferTo(new File(realpath));
				photoBoard.setSavedfile(savedfile);
				photoBoard.setMimetype(photoBoard.getPhoto().getContentType());				
			}else{
				//첨부파일을 안넣을 경우				
				photoBoard.setOriginalfile("★defualt.jpeg");
				photoBoard.setSavedfile("★defualt.jpeg");
				photoBoard.setMimetype("image/jpeg");				
			}
			int result = photoBoardService.write(photoBoard);
			
			return "redirect:/photoboard/list";
			
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/photoboard/list";
		}
	}

	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request, HttpServletResponse response) {
		try{
		String fileName = savedfile;
		//브라우져에서 보여주지 않고 강제로 다운로드 할경우
/*		fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); 
*/
				
		String mimeType = request.getServletContext().getMimeType(fileName); //()안의 파일의 확장명을보고 mime타입을 돌려줌
		response.setContentType(mimeType);
		
		OutputStream os = response.getOutputStream();
		String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);				
		InputStream is = new FileInputStream(filePath);
		byte[] values = new byte[1024];
		int byteNum = -1;
		while( (byteNum = is.read(values))!= -1 ){
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@RequestMapping("info")
	public String info(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		photoBoard.setBhitcount(photoBoard.getBhitcount() + 1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/info";
	}
	
   /*선생님 소스@RequestMapping("/info")
   public String info(int bno, Model model){   
      PhotoBoard photoBoard = photoBoardService.info(bno);
      photoBoard.setBhitcount(photoBoard.getBhitcount()+1);
      photoBoardService.modify(photoBoard);
      model.addAttribute("photoboard", photoBoard);
      return "photoboard/info";
   }
   */

	
/*	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/modify";
	}*/
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyForm(PhotoBoard photoBoard, HttpSession session){
		try{
			PhotoBoard dbFreeBoard = photoBoardService.info(photoBoard.getBno());
			photoBoard.setBhitcount(dbFreeBoard.getBhitcount());
		
			if(photoBoard.getPhoto().getOriginalFilename() != ""){
				//첨부파일을 수정할경우
				photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
				String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
				String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile); //저장할 파일의 절대 파일 시스템 경로
				photoBoard.getPhoto().transferTo(new File(realpath));
				photoBoard.setSavedfile(savedfile);
				photoBoard.setMimetype(photoBoard.getPhoto().getContentType());				
			}else{
				//첨부파일을 수정 안경우				
				photoBoard.setOriginalfile(dbFreeBoard.getOriginalfile());
				photoBoard.setSavedfile(dbFreeBoard.getSavedfile());
				photoBoard.setMimetype(dbFreeBoard.getMimetype());				
			}
			
			photoBoardService.modify(photoBoard);				
			return "redirect:/photoboard/list";
		
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/photoboard/list";
		}
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		photoBoardService.remove(bno);
		return "redirect:/photoboard/list";
	}

	
}
