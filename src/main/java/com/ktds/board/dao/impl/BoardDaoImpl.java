package com.ktds.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{

	@Override
	public List<BoardVO> getAllBoardList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("boardDao.getAllBoardList");
	}

	@Override
	public BoardVO getBoardById(String boardId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("boardDao.getBoardById", boardId);
	}

	@Override
	public int deleteBoardById(String boardId) {
		// TODO Auto-generated method stub
		return getSqlSession().delete("boardDao.deleteBoardById", boardId);
	}

	@Override
	public int insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("boardDao.insertBoard", board);
		
	}

	@Override
	public int updateHit(String boardId) {
		// TODO Auto-generated method stub
		return getSqlSession().update("boardDao.updateHit", boardId);
	}
	
	public int addHitHistory(String boardId, String userId){
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("boardId", boardId);
		parameter.put("userId", userId);
		return getSqlSession().insert("boardDao.addHitHistory", parameter);
	}

	@Override
	public int getHitbyId(String boardId, String userId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("boardId", boardId);
		parameter.put("userId", userId);
		return getSqlSession().selectOne("boardDao.getHitbyId", parameter);
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("boardDao.getBoardCount");
	}


	
}
