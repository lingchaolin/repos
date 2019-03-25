package com.aowin.statement.model;

public class StockNumModel {
	private String productCode;
	private String name;
	private int num;
	public StockNumModel() {
		super();
	}
	public StockNumModel(String productCode, String name, int num) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.num = num;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
