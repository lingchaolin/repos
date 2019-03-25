package com.aowin.sem.purchase.pojo;

public class Vender {
	private String venderCode;
	private String name;
	private String password;
	private String contactor;
	private String address;
	private String postcode;
	private String tel;
	private String fax;
	private String createDate;
	public Vender() {
		// TODO Auto-generated constructor stub
	}
	public Vender(String enderCode, String name, String password, String contactor, String address, String postcode,
			String tel, String fax, String createDate) {
		super();
		this.venderCode = enderCode;
		this.name = name;
		this.password = password;
		this.contactor = contactor;
		this.address = address;
		this.postcode = postcode;
		this.tel = tel;
		this.fax = fax;
		this.createDate = createDate;
	}
	/**
	 * @return the enderCode
	 */
	public String getEnderCode() {
		return venderCode;
	}
	/**
	 * @param enderCode the enderCode to set
	 */
	public void setEnderCode(String enderCode) {
		this.venderCode = enderCode;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the contactor
	 */
	public String getContactor() {
		return contactor;
	}
	/**
	 * @param contactor the contactor to set
	 */
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
