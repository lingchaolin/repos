package com.aowin.sem.inventory.pojo;

public class Instockrecord {
	private int stockId;
	private String productCode;
	private String orderCode;
	private int stockNum;
	private int stockType;
	private String stockTime;
	private String createUser;
	public Instockrecord() {
		// TODO Auto-generated constructor stub
	}
	public Instockrecord(int stockId, String productCode, String orderCode, int stockNum, int stockType,
			String stockTime, String createUser) {
		super();
		this.stockId = stockId;
		this.productCode = productCode;
		this.orderCode = orderCode;
		this.stockNum = stockNum;
		this.stockType = stockType;
		this.stockTime = stockTime;
		this.createUser = createUser;
	}
	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
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
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}
	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	/**
	 * @return the stockNum
	 */
	public int getStockNum() {
		return stockNum;
	}
	/**
	 * @param stockNum the stockNum to set
	 */
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	/**
	 * @return the stockType
	 */
	public int getStockType() {
		return stockType;
	}
	/**
	 * @param stockType the stockType to set
	 */
	public void setStockType(int stockType) {
		this.stockType = stockType;
	}
	/**
	 * @return the stockTime
	 */
	public String getStockTime() {
		return stockTime;
	}
	/**
	 * @param stockTime the stockTime to set
	 */
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

}
