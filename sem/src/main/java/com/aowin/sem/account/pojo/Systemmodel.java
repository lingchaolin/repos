package com.aowin.sem.account.pojo;

public class Systemmodel {
	private String modelCode;
	private String modelName;
	public Systemmodel() {
		// TODO Auto-generated constructor stub
	}
	public Systemmodel(String modelCode, String modelName) {
		super();
		this.modelCode = modelCode;
		this.modelName = modelName;
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
	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
