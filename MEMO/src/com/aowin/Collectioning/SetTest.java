package com.aowin.Collectioning;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
/**继承自Collection
 * 实现Set的类，有哈希表支持；
 * 无序
 * 可重复
 * @param args
 */
	
/**
 * 如何判断两个元素是否重复
 * 1,判断哈希码值，不同-->不重复
 * 				相同-->调用eauals()比较
 * 						true-->重复
 * 						false-->不重复
 * 
 * hashcode和equals:一起重写
 * @param args
 */
	public static void main(String[] args) {
		HashSet hs=new HashSet();
		//重复的元素不会添加；
		hs.add(new Student("Hinata",12));
		hs.add(new Student("Naruto",13));
		hs.add(new Student("Hinata",12));
		System.out.println(hs);
	}
	/**
	 * 迭代器迭代过程中删除元素，要用迭代器自己的方法
	 * foreach也是依靠迭代器遍历的
	 */
}
class Student{
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return 1001;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Student stu=(Student) obj;
		if(stu.age!=age)
			return false;
		if(name==null) {
			if(stu.name==null)
				return false;
		}else if(!name.equals(stu.name)) {
			return false;
		}
		return true;
	}
/*	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	
}