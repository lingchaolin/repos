package com.aowin.IOC;

import java.util.Date;

public class SequenceTwo {
	private int id;
	private String name;
	private Date date;
	private Rule rule;
	public SequenceTwo() {
		super();
	}
	//setter×¢Èë
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SequenceTwo [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
}
