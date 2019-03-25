package com.aowin.statement.model;

public class MoneyMessageModel {
	private String noid;
	private String createTime;
	private String payTime;
	private int total;
	private String payUser;
	private String status;
	public MoneyMessageModel() {
		super();
	}
	public MoneyMessageModel(String noid, String createTime, String payTime, int total, String payUser, int status) {
		super();
		this.noid = noid;
		this.createTime = createTime;
		this.payTime = payTime;
		this.total = total;
		this.payUser = payUser;
		if(status==1) {
			this.status="新单据";
		}else if(status==2) {
			this.status="已收货 ";
		}else if(status==3) {
			this.status="已付款";
		}else if(status==4) {
			this.status="已了结";
		}else if(status==5) {
			this.status="已预付";
		}
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPayUser() {
		return payUser;
	}
	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(int status) {
		if(status==1) {
			this.status="新单据";
		}else if(status==2) {
			this.status="已收货 ";
		}else if(status==3) {
			this.status="已付款";
		}else if(status==4) {
			this.status="已了结";
		}else if(status==5) {
			this.status="已预付";
		}
	}
	
}
