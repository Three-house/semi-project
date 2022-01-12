package com.tr.comment;

import java.util.Date;

public class Replies {
	private int re_no;
	private String re_name;
	private String re_content;
	private Date re_date;
	
	public Replies() {
		// TODO Auto-generated constructor stub
	}

	public int getRe_no() {
		return re_no;
	}

	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}

	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public Replies(int re_no, String re_name, String re_content, Date re_date) {
		super();
		this.re_no = re_no;
		this.re_name = re_name;
		this.re_content = re_content;
		this.re_date = re_date;
	}
	
	
	
}