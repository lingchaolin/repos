package com.aowin.food;

public class Food {
	String name;
	int Number;
	public Food() {
		super();
	}
	public Food(String name, int number) {
		super();
		this.name = name;
		Number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	
}
