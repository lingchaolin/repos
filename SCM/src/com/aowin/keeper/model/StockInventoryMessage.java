package com.aowin.keeper.model;

public class StockInventoryMessage {
	private String productcode;
	private String name;
	private int num;
	private int inStockNum;
	public StockInventoryMessage(String productcode, String name, int num) {
		super();
		this.productcode = productcode;
		this.name = name;
		this.num = num;
	}
	public StockInventoryMessage() {
		super();
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
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
	public int getInStockNum() {
		return inStockNum;
	}
	public void setInStockNum(int inStockNum) {
		this.inStockNum = inStockNum;
	}
	
}
