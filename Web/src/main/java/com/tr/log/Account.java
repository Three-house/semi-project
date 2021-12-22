package com.tr.log;

public class Account {

	private String name;
	private String id;
	private String pw;
	private String sex;
	private String num1;
	private String num2;
	private String num3;
	private String contact;
	private String postAddr1;
	private String postAddr2;
	private String postAddr3;
	private String addr;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String name, String id, String pw, String sex, String num1, String num2, String num3, String contact,
			String postAddr1, String postAddr2, String postAddr3, String addr) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.sex = sex;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.contact = contact;
		this.postAddr1 = postAddr1;
		this.postAddr2 = postAddr2;
		this.postAddr3 = postAddr3;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPostAddr1() {
		return postAddr1;
	}

	public void setPostAddr1(String postAddr1) {
		this.postAddr1 = postAddr1;
	}

	public String getPostAddr2() {
		return postAddr2;
	}

	public void setPostAddr2(String postAddr2) {
		this.postAddr2 = postAddr2;
	}

	public String getPostAddr3() {
		return postAddr3;
	}

	public void setPostAddr3(String postAddr3) {
		this.postAddr3 = postAddr3;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
