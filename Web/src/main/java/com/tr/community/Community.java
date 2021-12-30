package com.tr.community;

import java.util.Date;

public class Community {
	private int no;
	private String userId;
	private String title;
	private String content;
	private String img;
	private Date date;

	
	public Community() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Community(int no, String userId, String title, String content, String img, Date date) {
		super();
		this.no = no;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.img = img;
		this.date = date;
	}
	
}
