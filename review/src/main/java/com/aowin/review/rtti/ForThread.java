package com.aowin.review.rtti;

public class ForThread {
/**
 * 1*��������������ģ�͡�
Ҫ��
˫�̶߳�ͬһ�������
���߳����Զ���ֹ���������������޵ȴ���������������
����������һ�����������ж���
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