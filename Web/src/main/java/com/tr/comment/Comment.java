package com.tr.comment;

import java.util.Date;

public class Comment {
	private int boardID;
	private int commentID;
	private int bbsID;
	private String userID;
	private String commentText;
	private int commentAvailable;
	private String commentDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getBbsID() {
		return bbsID;
	}

	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public int getCommentAvailable() {
		return commentAvailable;
	}

	public void setCommentAvailable(int commentAvailable) {
		this.commentAvailable = commentAvailable;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public Comment(int boardID, int commentID, int bbsID, String userID, String commentText, int commentAvailable,
			String commentDate) {
		super();
		this.boardID = boardID;
		this.commentID = commentID;
		this.bbsID = bbsID;
		this.userID = userID;
		this.commentText = commentText;
		this.commentAvailable = commentAvailable;
		this.commentDate = commentDate;
	}

	
	
	
	
	
	
	
}
