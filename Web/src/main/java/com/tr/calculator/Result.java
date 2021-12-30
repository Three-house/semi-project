package com.tr.calculator;

public class Result {

	private double result;
	private int price;
	private double confer;
	private String deal_sort;
	private String sort;
	

public Result() {
	// TODO Auto-generated constructor stub
}


public double getResult() {
	return result;
}


public void setResult(double result) {
	this.result = result;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public double getConfer() {
	return confer;
}


public void setConfer(double confer) {
	this.confer = confer;
}


public String getDeal_sort() {
	return deal_sort;
}


public void setDeal_sort(String deal_sort) {
	this.deal_sort = deal_sort;
}


public String getSort() {
	return sort;
}


public void setSort(String sort) {
	this.sort = sort;
}


public Result(double result, int price, double confer, String deal_sort, String sort) {
	super();
	this.result = result;
	this.price = price;
	this.confer = confer;
	this.deal_sort = deal_sort;
	this.sort = sort;
}


	
	
}
