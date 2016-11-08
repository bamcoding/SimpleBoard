package com.ktds.board.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.util.DownloadUtil;

@Controller
public class BoardController {
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board")
	public ModelAndView viewListPage(){
		BoardListVO boardList = boardService.getAllBoards();
		
		ModelAndView view = new ModelAndView();
		view.addObject("boardList", boardList);
		view.setViewName("board/boardList");
		return view;
	}
	
	/**
	 * 상세보기를 만들었습니다.
	 * @param boardId
	 * @return
	 */
	@RequestMapping("/detail/{boardId}")
	public ModelAndView viewDetailPage(@PathVariable String boardId, HttpSession session){
		BoardVO board = boardService.getBoardById(boardId, session);
		ModelAndView view = new ModelAndView();
		view.setViewName("board/detail");
		view.addObject("board",board);
		return view;
	}
	@RequestMapping("/delete/{boardId}")
	public ModelAndView doDeleteAction(@PathVariable String boardId){
		boolean isSuccess = boardService.deleteBoardById(boardId);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board");
		return view;
	}
	
	/**
	 * 글쓰기 기능을 만들었습니다.
	 * @return
	 */
	@RequestMapping("/write")
	public String viewWritePage(){
		return "board/write";
	}
	
	@RequestMapping("/doWrite")
	public ModelAndView doWriteAction(BoardVO board){
		MultipartFile uploadFile = board.getFileUpload();
		if(!uploadFile.isEmpty()){
			File dir = new File("D:" + File.separator + "uploadFile2");
			if(!dir.exists()){
				dir.mkdirs();
			}
			String uploadPath = dir.getAbsolutePath();
			String encryptFileName = UUID.randomUUID().toString();
			String realFileName = uploadFile.getOriginalFilename();
			File file = new File(uploadPath + File.separator + encryptFileName);
			try {
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(),e);
				} catch (IOException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
			//서버의 입장과 사용자의 입장이 다르다.
			board.setDisplayFileName(realFileName);
			board.setRealFileName(encryptFileName);
			
		}
		
		boolean isSuccess = boardService.insertBoard(board);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board");
		return view;
	}
	
	
	@RequestMapping("/doDownload/{boardId}")
	public void doDownloadAction(@PathVariable String boardId, HttpServletRequest request, HttpServletResponse response){
		BoardVO board = boardService.getFileNames(boardId);
		DownloadUtil downloadFile = DownloadUtil.getInstance("D:"+File.separator+"uploadFile2");
		try {
			downloadFile.download(request, response, board.getRealFileName(), board.getDisplayFileName());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
