package com.ktds.admin.operation.history.biz.impl;

import com.ktds.admin.operation.history.biz.HistoryBiz;
import com.ktds.admin.operation.history.dao.HistoryDao;

public class HistoryBizImpl implements HistoryBiz{
	private HistoryDao historyDao;

	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
	
}
