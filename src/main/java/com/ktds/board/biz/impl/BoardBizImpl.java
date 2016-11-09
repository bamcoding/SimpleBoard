package com.ktds.board.biz.impl;

import javax.servlet.http.HttpSession;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.user.vo.UserVO;

public class BoardBizImpl implements BoardBiz{
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public BoardListVO getAllBoardList() {
		// TODO Auto-generated method stub
		BoardListVO boardList= new BoardListVO();
		boardList.setBoardList(boardDao.getAllBoardList());
		return boardList;
	}

	@Override
	public BoardVO getBoardById(String boardId, String userId) {
		// TODO Auto-generated method stub
		BoardVO board = boardDao.getBoardById(boardId);
		System.out.println("세션으로 받은 유저 아이디 : "+userId);
		System.out.println("보드로 받은 유저 아이디 : "+ board.getUserId());
		if(boardDao.getHitbyId(boardId, userId)==0 && !board.getUserId().equals(userId)){
			boardDao.updateHit(boardId);
		}
		boardDao.addHitHistory(boardId, userId);
		
		return board;
	}

	@Override
	public boolean deleteBoardById(String boardId, String userId) {
		// TODO Auto-generated method stub
		BoardVO board = boardDao.getBoardById(boardId);
		String userIdOfBoard = board.getUserId();
		if(userId.equals(userIdOfBoard)){
			return boardDao.deleteBoardById(boardId)>0;
		}else{
			return false;
		}
	}

	@Override
	public boolean insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board)>0;
	}

	@Override
	public BoardVO getFileNames(String boardId) {
		// TODO Auto-generated method stub
		return boardDao.getBoardById(boardId);
	}

	@Override
	public boolean getHitbyId(String boardId, String userId) {
		// TODO Auto-generated method stub
		return boardDao.getHitbyId(boardId, userId)>0;
	}
	public BoardVO getBoard(String boardId) {
		return boardDao.getBoardById(boardId);
	}
}
