package com.aowin.review.rtti;

public class ForThread {
/**
 * 1*做生产者消费者模型。
要求：
双线程对同一对象操作
各线程能自动终止。即：不存在无限等待，或者死锁现象。
程序启动在一个独立的类中定义
 */
	public ForThread() {

	}

	public static void main(String[] args) {

	}

}
class Consumer extends Thread{
	
}

class Goods{
	int num;

	public Goods(int num) {
		super();
		this.num = num;
	}

	public Goods() {
		super();
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	public void addNum(){
		num++;
	}
	public void reduceNum(){
		num--;
	}
}