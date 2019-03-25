package com.aowin.forIO;

import java.io.*;

public class ByteFileObjectIO implements Serializable{
	public static void main(String[] args) {
		File file=new File("F:/test.txt");
		try {
			ObjectIOout(file);
			System.out.println("∂¡»°");
			ObjectIOin(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void ObjectIOin(File src) throws Exception {
		ObjectInputStream ois=null;
			ois=new ObjectInputStream(new FileInputStream(src));
			try {
				while(true) {
					System.out.println(ois.readObject());
				}
			} catch (EOFException e) {
				ois.close();
			}
	}
	public static void ObjectIOout(File dest) throws Exception {
		ObjectOutputStream oos = null;
			oos=new ObjectOutputStream(new FileOutputStream(dest));
			oos.writeObject(new Dog("101",4));
			oos.writeObject(new Dog("102",8));
			oos.writeObject(new Dog("103",6));
			oos.close();
	}
}
class Dog implements Serializable{
	String name;
	int age;
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
}