package com.aowin.cla;

import java.util.Date;

public class ClassC {
	private int id;
	private String name;
	private Date date;
	
	InterfaceOne io;

	public ClassC(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassC [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	public ClassC() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the io
	 */
	public InterfaceOne getIo() {
		return io;
	}

	/**
	 * @param io the io to set
	 */
	public void setIo(InterfaceOne io) {
		this.io = io;
	}
	
}