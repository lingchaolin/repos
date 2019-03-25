package com.aowin.sem.purchase.pojo;

public class Poitem {
	private String poid;
	private String productCode;
	private double unitPrice;
	private int num;
	private String unitName;
	private double itemPrice;
	public Poitem() {
		// TODO Auto-generated constructor stub
	}
	public Poitem(String poid, String productCode, double unitPrice, int num, String unitName, double itemPrice) {
		super();
		this.poid = poid;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the poid
	 */
	public String getPoid() {
		return poid;
	}
	/**
	 * @param poid the poid to set
	 */
	public void setPoid(String poid) {
		this.poid = poid;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
