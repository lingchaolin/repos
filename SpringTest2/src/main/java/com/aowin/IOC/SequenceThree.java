package com.aowin.IOC;

import java.util.Date;

public class SequenceThree{
	private int id;
	private String name;
	private Date date;
	//¹¹ÔìÆ÷×¢Èë
	public SequenceThree(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	@Override
	public String toString() {
		return "SequenceThree [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
}
