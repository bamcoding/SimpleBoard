package com.ktds.admin.operation.history.service.impl;

import com.ktds.admin.operation.history.biz.HistoryBiz;
import com.ktds.admin.operation.history.service.HistoryService;

public class HistoryServiceImpl implements HistoryService{
	private HistoryBiz historyBiz;

	public void setHistoryBiz(HistoryBiz historyBiz) {
		this.historyBiz = historyBiz;
	}
	
	
}
