package com.aowin.scm.account.pojo;

public class Usermodel {
	private String account;
	private String modelCode;
	public Usermodel() {
		// TODO Auto-generated constructor stub
	}
	public Usermodel(String account, String modelCode) {
		super();
		this.account = account;
		this.modelCode = modelCode;
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
	 * @return the modelCode
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * @param modelCode the modelCode to set
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
}
