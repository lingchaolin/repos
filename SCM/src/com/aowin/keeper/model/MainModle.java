package com.aowin.keeper.model;

public class MainModle {
	private String noid;//soid&poid
	private String createTime;
	private String outerName;//customerName&venderName
	private String userName;
	private double tipFee;
	private double productTotal;
	private double toTotal;//soTotal&poTal
	private String payType;
	private double prePayFee;
	private String status;
	public MainModle() {
		super();
	}
	public String getSoid() {
		return noid;
	}
	public void setSoid(String soid) {
		this.noid = soid;
	}
	public String getCustomerName() {
		return outerName;
	}
	public void setCustomerName(String customerName) {
		this.outerName = customerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getSoTotal() {
		return toTotal;
	}
	public void setSoTotal(double soTotal) {
		this.toTotal = soTotal;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrePayFee() {
		return prePayFee;
	}
	public void setPrePayFee(double prePayFee) {
		this.prePayFee = prePayFee;
	}
	public MainModle(String soid, String createTime, String customerName, String userName, double tipFee,
			double productTotal, double soTotal, String payType, double prePayFee, int status) {
		super();
		this.noid = soid;
		this.createTime = createTime;
		this.outerName = customerName;
		this.userName = userName;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.toTotal = soTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
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
	public MainModle(String payType, int status) {
		super();
		this.payType = payType;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public double getTipFee() {
		return tipFee;
	}
	public void setTipFee(double tipFee) {
		this.tipFee = tipFee;
	}
	public double getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
	@Override
	public String toString() {
		return "MainModle [noid=" + noid + ", createTime=" + createTime + ", outerName=" + outerName + ", userName="
				+ userName + ", tipFee=" + tipFee + ", productTotal=" + productTotal + ", toTotal=" + toTotal
				+ ", payType=" + payType + ", prePayFee=" + prePayFee + ", status=" + status + "]";
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public String getOuterName() {
		return outerName;
	}
	public void setOuterName(String outerName) {
		this.outerName = outerName;
	}
	public double getToTotal() {
		return toTotal;
	}
	public void setToTotal(double toTotal) {
		this.toTotal = toTotal;
	}
}
