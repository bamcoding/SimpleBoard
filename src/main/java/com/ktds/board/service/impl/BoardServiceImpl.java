package com.ktds.board.service.impl;

import javax.servlet.http.HttpSession;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.vo.UserVO;

public class BoardServiceImpl implements BoardService{
	
	private BoardBiz boardBiz;
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public BoardListVO getAllBoards() {
		// TODO Auto-generated method stub
		return boardBiz.getAllBoardList();
	}

	/**
	 * 한 번 읽은 글은 조회수가 증가하지 않는다.
	 * 당사자가 쓴 글은 조회수가 증가하지 않는다.
	 */
	@Override
	public BoardVO getBoardById(String boardId, HttpSession session) {
		// TODO Auto-generated method stub
		UserVO user = (UserVO) session.getAttribute("_USER_");
		String userId = user.getUserId();
		
		if(!boardBiz.getHitbyId(boardId,userId)){
			userBiz.updatePoint(userId, -5);//나중에 한번 읽은 글은 더이상 포인트가 감소하지 않도록 할 것임.
		}
		
		return boardBiz.getBoardById(boardId, userId);
	}

	@Override
	public boolean deleteBoardById(String boardId, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("_USER_");
		String userId = user.getUserId();
		// TODO Auto-generated method stub
		return boardBiz.deleteBoardById(boardId, userId);
	}

	@Override
	public boolean insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
		return boardBiz.insertBoard(board);
	}

	@Override
	public BoardVO getFileNames(String boardId, HttpSession session) {
		// TODO Auto-generated method stub
		UserVO user = (UserVO) session.getAttribute("_USER_");
		String userId = user.getUserId();
		BoardVO board = boardBiz.getBoard(boardId);
		if(!board.getUserId().equals(userId)){
			userBiz.updatePoint(userId, -3);
		}
		return boardBiz.getFileNames(boardId);
	}
}
