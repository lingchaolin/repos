package com.aowin.scm.inventory.pojo;

public class Category {
	private int CategoryId;
	private String name;
	private String remark;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String name, String remark) {
		super();
		CategoryId = categoryId;
		this.name = name;
		this.remark = remark;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return CategoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
