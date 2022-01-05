package com.tr.sales;

import java.util.Date;

public class sales {

	private String num;
	private String name;
	private String salesort;
	private String location;
	private String size;
	private String condition;
	private String price;
	private Date date;
	private String etc;
	private String img1;
	private String img2;
	private String img3;
	private String contact;

	public sales() {
		// TODO Auto-generated constructor stub
	}

	public sales(String num, String name, String salesort, String location, String size, String condition, String price,
			Date date, String etc, String img1, String img2, String img3, String contact) {
		super();
		this.num = num;
		this.name = name;
		this.salesort = salesort;
		this.location = location;
		this.size = size;
		this.condition = condition;
		this.price = price;
		this.date = date;
		this.etc = etc;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.contact = contact;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalesort() {
		return salesort;
	}

	public void setSalesort(String salesort) {
		this.salesort = salesort;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
