package com.aowin.keeper.model;

public class SubModel {
	private String noid;
	private String productCode;
	private double unitPrice;
	private int num;
	private String unitname;
	private double itemPrice;
	public SubModel(String poid, String productCode, double unitPrice, int num, String unitname,
			double itemPrice) {
		super();
		this.noid = poid;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitname = unitname;
		this.itemPrice = itemPrice;
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public SubModel() {
		super();
	}
	public String getPoid() {
		return noid;
	}
	public void setPoid(String poid) {
		this.noid = poid;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "PoitemInStockMessage [poid=" + noid + ", productCode=" + productCode + ", unitPrice=" + unitPrice
				+ ", num=" + num + ", unitname=" + unitname + ", itemPrice=" + itemPrice + "]";
	}
	
}
