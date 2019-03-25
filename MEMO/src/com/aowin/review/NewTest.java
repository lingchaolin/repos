package com.aowin.review;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewTest {
	public static void main(String[] args) {
		Dog d1=new Dog(12);
		Dog d2=new Dog(15);
		Dog d3=new Dog(6);
		Dog d4=new Dog(13);
		List<Dog> list=new ArrayList<>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		System.out.println(Arrays.toString(list.toArray()));
//		Collections.sort(list);
		Collections.sort(list, new DogComparator());
		System.out.println(Arrays.toString(list.toArray()));
	}
}
class Dog /*implements Comparable<Dog>*/{
	int age;
	public Dog(int age) {
		super();
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
/*	@Override
	public int compareTo(Dog dog) {
		return this.age-dog.getAge();
	}*/
	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}
}
class DogComparator implements Comparator<Dog>{
	@Override
	public int compare(Dog d1,Dog d2) {
		return d1.getAge()-d2.getAge();
	}
	
}