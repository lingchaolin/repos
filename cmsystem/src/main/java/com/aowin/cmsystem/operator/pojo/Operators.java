/**
 * 
 */
package com.aowin.cmsystem.operator.pojo;

import java.io.Serializable;

/**
 * 操作员基本信息
 * @author TY
 * create date: 2018年8月15日 上午9:23:04
 */
public class Operators implements Serializable {
	
	private Integer operatorid;
	private String operatorname;
	private String operatorsex;
	private String username;
	private String userpwd;
	private String isadmin;

	public Operators() {
		// TODO Auto-generated constructor stub
	}

	public Operators(Integer operatorid, String operatorname, String operatorsex, String username, String userpwd,
			String isadmin) {
		super();
		this.operatorid = operatorid;
		this.operatorname = operatorname;
		this.operatorsex = operatorsex;
		this.username = username;
		this.userpwd = userpwd;
		this.isadmin = isadmin;
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

	@Override
	public String toString() {
		return "Operators [operatorid=" + operatorid + ", operatorname=" + operatorname + ", operatorsex=" + operatorsex
				+ ", username=" + username + ", userpwd=" + userpwd + ", isadmin=" + isadmin + "]";
	}

	
	
}
