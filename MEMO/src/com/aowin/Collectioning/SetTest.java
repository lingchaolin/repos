package com.aowin.Collectioning;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
/**�̳���Collection
 * ʵ��Set���࣬�й�ϣ��֧�֣�
 * ����
 * ���ظ�
 * @param args
 */
	
/**
 * ����ж�����Ԫ���Ƿ��ظ�
 * 1,�жϹ�ϣ��ֵ����ͬ-->���ظ�
 * 				��ͬ-->����eauals()�Ƚ�
 * 						true-->�ظ�
 * 						false-->���ظ�
 * 
 * hashcode��equals:һ����д
 * @param args
 */
	public static void main(String[] args) {
		HashSet hs=new HashSet();
		//�ظ���Ԫ�ز�����ӣ�
		hs.add(new Student("Hinata",12));
		hs.add(new Student("Naruto",13));
		hs.add(new Student("Hinata",12));
		System.out.println(hs);
	}
	/**
	 * ����������������ɾ��Ԫ�أ�Ҫ�õ������Լ��ķ���
	 * foreachҲ������������������
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