package com.aowin.manager.model;

public class AccountMessage {
	private String account;
	private String name;
	private String createDate;
	private String status;
	private String modelName;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public AccountMessage(String account, String name, String createDate, String status, String modelName) {
		super();
		this.account = account;
		this.name = name;
		this.createDate = createDate;
		this.status = status;
		this.modelName = modelName;
	}
	public AccountMessage() {
		super();
	}
	@Override
	public String toString() {
		return "AccountMessage [account=" + account + ", name=" + name + ", createDate=" + createDate + ", status="
				+ status + ", modelName=" + modelName + "]";
	}
	
}
