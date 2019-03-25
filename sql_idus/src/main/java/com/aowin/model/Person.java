package com.aowin.model;

public class Person {
	private int id;
	private String name;
	private int sex;
	private String depart;
	private int salary;
	public Person() {
		super();
	}
	public Person(int id, String name, int sex, String depart, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.depart = depart;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", depart=" + depart + ", salary=" + salary
				+ "]";
	}
}
