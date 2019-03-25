package com.aowin.model;

public class People {

	private int id;
	private String name;
	private int sex;
	private String department;
	private int salary;
	public People() {
	}
	public People(String name, int sex, String department, int salary) {
		super();
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}
	public People(int id, String name, int sex, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
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
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", sex=" + sex + ", department=" + department + ", salary="
				+ salary + "]";
	}


}
