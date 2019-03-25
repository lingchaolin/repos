package com.aowin.keeper.model;

public class ProductInStockMessage {
	private String name;
	private String unitName;
	private int poNum;
	private int soNum;
	public ProductInStockMessage() {
		super();
	}
	public ProductInStockMessage(String name, String unitName, int poNum, int soNum) {
		super();
		this.name = name;
		this.unitName = unitName;
		this.poNum = poNum;
		this.soNum = soNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public int getPoNum() {
		return poNum;
	}
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	public int getSoNum() {
		return soNum;
	}
	public void setSoNum(int soNum) {
		this.soNum = soNum;
	}
	
}
