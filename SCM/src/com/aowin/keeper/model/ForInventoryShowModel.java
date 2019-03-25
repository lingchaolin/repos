package com.aowin.keeper.model;

public class ForInventoryShowModel {
	private String productcode;
	private String name;
	private int num;
	private int ponum;
	private int sonum;
	public ForInventoryShowModel() {
		super();
	}
	public ForInventoryShowModel(String productcode, String name, int num, int ponum, int sonum) {
		super();
		this.productcode = productcode;
		this.name = name;
		this.num = num;
		this.ponum = ponum;
		this.sonum = sonum;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPonum() {
		return ponum;
	}
	public void setPonum(int ponum) {
		this.ponum = ponum;
	}
	public int getSonum() {
		return sonum;
	}
	public void setSonum(int sonum) {
		this.sonum = sonum;
	}

	
}
