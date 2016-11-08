package com.ktds.board.biz;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.user.vo.UserVO;

public interface BoardBiz {

	public BoardListVO getAllBoardList();

	public BoardVO getBoardById(String boardId, String userId);

	public boolean deleteBoardById(String boardId);

	public boolean insertBoard(BoardVO board);

	public BoardVO getFileNames(String boardId);
	
}
