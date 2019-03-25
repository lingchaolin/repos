package com.aowin.model;

public class Usermodel {

	private String account;
	private String modelCode;
	public Usermodel() {
		super();
	}
	public Usermodel(String account, String modelCode) {
		super();
		this.account = account;
		this.modelCode = modelCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
}
