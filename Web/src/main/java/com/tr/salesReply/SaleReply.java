package com.tr.salesReply;

import java.util.Date;

public class SaleReply {
	private int s_no;
	private String s_name;
	private String s_content;
	private Date s_date;
	
	public SaleReply() {
		// TODO Auto-generated constructor stub
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public SaleReply(int s_no, String s_name, String s_content, Date s_date) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_content = s_content;
		this.s_date = s_date;
	}
	
	
}
