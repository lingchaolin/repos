package com.fuckaowin.sms.operator.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Operators implements Serializable {
	private Integer operatorid;
	@NotBlank(message="姓名不能为空")
	private String operatorname;
	private String operatorsex;
	@NotBlank(message="用户名不能为空")
	private String username;
	@NotBlank(message="密码不能为空")
	private String userpwd;
	private String isadmin;
	
	public Operators() {
	}


	@Override
	public String toString() {
		return "Operators [operatorid=" + operatorid + ", operatorname=" + operatorname + ", operatorsex=" + operatorsex
				+ ", username=" + username + ", userpwd=" + userpwd + ", isadmin=" + isadmin + "]";
	}


	/**
	 * @return the operatorid
	 */
	public Integer getOperatorid() {
		return operatorid;
	}


	/**
	 * @param operatorid the operatorid to set
	 */
	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}


	/**
	 * @return the operatorname
	 */
	public String getOperatorname() {
		return operatorname;
	}


	/**
	 * @param operatorname the operatorname to set
	 */
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}


	/**
	 * @return the operatorsex
	 */
	public String getOperatorsex() {
		return operatorsex;
	}


	/**
	 * @param operatorsex the operatorsex to set
	 */
	public void setOperatorsex(String operatorsex) {
		this.operatorsex = operatorsex;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the userpwd
	 */
	public String getUserpwd() {
		return userpwd;
	}


	/**
	 * @param userpwd the userpwd to set
	 */
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	/**
	 * @return the isadmin
	 */
	public String getIsadmin() {
		return isadmin;
	}


	/**
	 * @param isadmin the isadmin to set
	 */
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

}