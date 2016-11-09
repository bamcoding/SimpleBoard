package com.ktds.admin.operation.history.vo;

public class HistoryVO {
	private String opreationHistoryId;
	private String userId;
	private String operation;
	private String ip;
	private String operationType;
	
	public String getOpreationHistoryId() {
		return opreationHistoryId;
	}
	public void setOpreationHistoryId(String opreationHistoryId) {
		this.opreationHistoryId = opreationHistoryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	
}
