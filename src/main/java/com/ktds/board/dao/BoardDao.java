package com.ktds.board.dao;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardDao {

	public List<BoardVO> getAllBoardList();

	public BoardVO getBoardById(String boardId);

	public int deleteBoardById(String boardId);

	public int insertBoard(BoardVO board);

	public int updateHit(String boardId);
	
	public int addHitHistory(String boardId, String userId);

	public int getHitbyId(String boardId, String userId);
	
	public int getBoardCount();

}
