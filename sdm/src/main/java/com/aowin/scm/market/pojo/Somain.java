package com.aowin.scm.market.pojo;

public class Somain {
	private String customerCode;
	private String account;
	private String createTime;
	private double TipFee;
	private double productTotal;
	private double soTotal;
	private String payType;
	private String prePayFee;
	private int status;
	private String remark;
	private String stockTime;
	private String stockUser;
	private String payTime;
	private String payUser;
	private String prePayTime;
	private String prePayUser;
	private String endTime;
	private String endUser;
	public Somain() {
		// TODO Auto-generated constructor stub
	}
	public Somain(String customerCode, String account, String createTime, double tipFee, double productTotal,
			double soTotal, String payType, String prePayFee, int status, String remark, String stockTime,
			String stockUser, String payTime, String payUser, String prePayTime, String prePayUser, String endTime,
			String endUser) {
		super();
		this.customerCode = customerCode;
		this.account = account;
		this.createTime = createTime;
		TipFee = tipFee;
		this.productTotal = productTotal;
		this.soTotal = soTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
		this.status = status;
		this.remark = remark;
		this.stockTime = stockTime;
		this.stockUser = stockUser;
		this.payTime = payTime;
		this.payUser = payUser;
		this.prePayTime = prePayTime;
		this.prePayUser = prePayUser;
		this.endTime = endTime;
		this.endUser = endUser;
	}
	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the tipFee
	 */
	public double getTipFee() {
		return TipFee;
	}
	/**
	 * @param tipFee the tipFee to set
	 */
	public void setTipFee(double tipFee) {
		TipFee = tipFee;
	}
	/**
	 * @return the productTotal
	 */
	public double getProductTotal() {
		return productTotal;
	}
	/**
	 * @param productTotal the productTotal to set
	 */
	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}
	/**
	 * @return the soTotal
	 */
	public double getSoTotal() {
		return soTotal;
	}
	/**
	 * @param soTotal the soTotal to set
	 */
	public void setSoTotal(double soTotal) {
		this.soTotal = soTotal;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the prePayFee
	 */
	public String getPrePayFee() {
		return prePayFee;
	}
	/**
	 * @param prePayFee the prePayFee to set
	 */
	public void setPrePayFee(String prePayFee) {
		this.prePayFee = prePayFee;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the stockUser
	 */
	public String getStockUser() {
		return stockUser;
	}
	/**
	 * @param stockUser the stockUser to set
	 */
	public void setStockUser(String stockUser) {
		this.stockUser = stockUser;
	}
	/**
	 * @return the payTime
	 */
	public String getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the payUser
	 */
	public String getPayUser() {
		return payUser;
	}
	/**
	 * @param payUser the payUser to set
	 */
	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}
	/**
	 * @return the prePayTime
	 */
	public String getPrePayTime() {
		return prePayTime;
	}
	/**
	 * @param prePayTime the prePayTime to set
	 */
	public void setPrePayTime(String prePayTime) {
		this.prePayTime = prePayTime;
	}
	/**
	 * @return the prePayUser
	 */
	public String getPrePayUser() {
		return prePayUser;
	}
	/**
	 * @param prePayUser the prePayUser to set
	 */
	public void setPrePayUser(String prePayUser) {
		this.prePayUser = prePayUser;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the endUser
	 */
	public String getEndUser() {
		return endUser;
	}
	/**
	 * @param endUser the endUser to set
	 */
	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

}
