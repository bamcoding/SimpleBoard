package com.ktds.board.biz.impl;

import javax.servlet.http.HttpSession;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;

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
		if(boardDao.getHitbyId(boardId, userId)==0){
			boardDao.updateHit(boardId);
		}
		boardDao.addHistory(boardId, userId);
		return boardDao.getBoardById(boardId);
	}

	@Override
	public boolean deleteBoardById(String boardId) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoardById(boardId)>0;
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
}
