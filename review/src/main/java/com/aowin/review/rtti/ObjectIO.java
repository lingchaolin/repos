package com.aowin.review.rtti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIO {

	public ObjectIO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void objIn() throws Exception {
		File file=new File("D:/Class/in2.txt");
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
		Object obj=ois.readObject();
		Cat cat=(Cat)obj;
		System.out.println("cat");
		System.out.println(cat.getName()+":"+cat.getAge());
	}
	public void objOut() throws Exception {
		File file=new File("D:/Class/in2.txt");
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		Cat dog=new Cat("����", 123);
		oos.writeObject(dog);
		oos.flush();
		oos.close();
	}
}
class Cat implements Serializable{
	String name;
	int age;
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Cat() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}