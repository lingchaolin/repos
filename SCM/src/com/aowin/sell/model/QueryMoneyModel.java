package com.aowin.sell.model;

public class QueryMoneyModel {
	private String payTime;
	private String noid;
	private double total;
	private String payUser;
	private String payType;
	public QueryMoneyModel() {
		super();
	}

	public QueryMoneyModel(String payTime, String noid, double total, String payUser, String payType) {
		super();
		this.payTime = payTime;
		this.noid = noid;
		this.total = total;
		this.payUser = payUser;
		this.payType = payType;
	}

	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPayuser() {
		return payUser;
	}
	public void setPayuser(String payUser) {
		this.payUser = payUser;
	}

	@Override
	public String toString() {
		return "QueryMoneyModel [payTime=" + payTime + ", noid=" + noid + ", total=" + total + ", payUser=" + payUser
				+ ", payType=" + payType + "]";
	}
	
}
