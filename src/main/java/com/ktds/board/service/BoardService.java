package com.ktds.board.service;

import javax.servlet.http.HttpSession;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public BoardListVO getAllBoards();

	public BoardVO getBoardById(String boardId, HttpSession session);

	public boolean deleteBoardById(String boardId);

	public boolean insertBoard(BoardVO board);

	public BoardVO getFileNames(String boardId);

}
