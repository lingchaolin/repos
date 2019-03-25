package com.aowin.statement.model;

public class MoneyIOModel {
	private int money;
	private int time;
	public MoneyIOModel(int money, int time) {
		super();
		this.money = money;
		this.time = time;
	}
	public MoneyIOModel() {
		super();
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
