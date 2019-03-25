package com.aowin.keeper.model;

public class RecordModel {
	private String productCode;
	private String orderCode;
	private int stockNum;
	private String stockType;
	private String stockTime;
	private String CreateUser;
	public RecordModel() {
		super();
	}
	public RecordModel(String productCode, String orderCode, int stockNum, int stockType,
			String stockTime, String createUser) {
		super();
		this.productCode = productCode;
		this.orderCode = orderCode;
		this.stockNum = stockNum;
		if(stockType==200) {
			this.stockType="采购入库";
		}else if(stockType==201) {
			this.stockType="盘点入库";
		}else if(stockType==202) {
			this.stockType="销售出库";
		}else if(stockType==203) {
			this.stockType="盘点出库";
		}
		this.stockTime = stockTime;
		CreateUser = createUser;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(int stockType) {
		if(stockType==200) {
			this.stockType="采购入库";
		}else if(stockType==201) {
			this.stockType="盘点入库";
		}else if(stockType==202) {
			this.stockType="销售出库";
		}else if(stockType==203) {
			this.stockType="盘点出库";
		}
	}
	public String getStockTime() {
		return stockTime;
	}
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	public String getCreateUser() {
		return CreateUser;
	}
	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}
	
	
}
