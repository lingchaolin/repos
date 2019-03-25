/**
 * 
 */
package com.aowin.smsystem.resource.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Resource implements Serializable {

	/**
	 * 
	 */
	private String mobilenummber;
	private String numbertype;
	private String cardnumber;
	private String isavailable;
	
	public Resource() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resource [mobilenummber=" + mobilenummber + ", numbertype=" + numbertype + ", cardnumber=" + cardnumber
				+ ", isavailable=" + isavailable + "]";
	}

	/**
	 * @return the mobilenummber
	 */
	public String getMobilenummber() {
		return mobilenummber;
	}

	/**
	 * @param mobilenummber the mobilenummber to set
	 */
	public void setMobilenummber(String mobilenummber) {
		this.mobilenummber = mobilenummber;
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

}
