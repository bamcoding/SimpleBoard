package com.ktds.board.vo;

import org.springframework.web.multipart.MultipartFile;

import com.ktds.user.vo.UserVO;

public class BoardVO {

		private String boardId;
		private String subject;
		private String content;
		private String userId;
		private String createdDate;
		private int hit;
		private int recommand;
		
		private String displayFileName;
		private String realFileName;
		
		MultipartFile fileUpload;	
		
		UserVO user;
		
		
		
		public MultipartFile getFileUpload() {
			return fileUpload;
		}
		public void setFileUpload(MultipartFile fileUpload) {
			
			this.fileUpload = fileUpload;
		}
		public String getDisplayFileName() {
			if(displayFileName.length()==0||displayFileName==null){
				displayFileName = "";
			}
			return displayFileName;
		}
		public void setDisplayFileName(String displayFileName) {
			this.displayFileName = displayFileName;
		}
		public String getRealFileName() {
			if(realFileName.length()==0||realFileName==null){
				realFileName = "";
			}
			return realFileName;
		}
		public void setRealFileName(String realFileName) {
			this.realFileName = realFileName;
		}
		public UserVO getUser() {
			return user;
		}
		public void setUser(UserVO user) {
			this.user = user;
		}
		public String getBoardId() {
			return boardId;
		}
		public void setBoardId(String boardId) {
			this.boardId = boardId;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public int getRecommand() {
			return recommand;
		}
		public void setRecommand(int recommand) {
			this.recommand = recommand;
		}
}
