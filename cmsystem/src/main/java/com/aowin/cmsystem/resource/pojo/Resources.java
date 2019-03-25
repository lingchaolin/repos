/**
 * 
 */
package com.aowin.cmsystem.resource.pojo;

import java.io.Serializable;

/**
 * 资源基本信息
 * @author TY
 * create date: 2018年8月15日 上午9:48:18
 */
public class Resources implements Serializable {
	
	private String mobilenumber;
	private String numbertype;
	private String cardnumber;
	private String isavailable;

	/**
	 * 
	 */
	public Resources() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the mobilenumber
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * @param mobilenumber the mobilenumber to set
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * @return the numbertype
	 */
	public String getNumbertype() {
		return numbertype;
	}

	/**
	 * @param numbertype the numbertype to set
	 */
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}

	/**
	 * @return the cardnumber
	 */
	public String getCardnumber() {
		return cardnumber;
	}

	/**
	 * @param cardnumber the cardnumber to set
	 */
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	/**
	 * @return the isavailable
	 */
	public String getIsavailable() {
		return isavailable;
	}

	/**
	 * @param isavailable the isavailable to set
	 */
	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}

	@Override
	public String toString() {
		return "Resources [mobilenumber=" + mobilenumber + ", numbertype=" + numbertype + ", cardnumber=" + cardnumber
				+ ", isavailable=" + isavailable + "]";
	}
	
	

}
