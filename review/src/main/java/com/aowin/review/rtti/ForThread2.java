package com.aowin.review.rtti;

public class ForThread2 {
/**
 * ��� 4 ���̣߳����������߳�ÿ�ζ� j���� 1��
 * ���������̶߳� jÿ�μ��� 1��д������ 
 */
	public ForThread2() {

	}

	public static void main(String[] args) {
		int j=0;
		Thread thread11=new Thread(new Thread1(j));
		Thread thread12=new Thread(new Thread1(j));
		
		Thread thread21=new Thread(new Thread2(j));
		Thread thread22=new Thread(new Thread2(j));
		thread11.start();
		thread12.start();
		thread21.start();
		thread22.start();
	}

}
class Thread1 implements Runnable{
	private int j;
	
	public Thread1() {
		super();
	}

	public Thread1(int j) {
		super();
		this.j = j;
	}

	/**
	 * @return the j
	 */
	public int getJ() {
		return j;
	}

	/**
	 * @param j the j to set
	 */
	public void setJ(int j) {
		this.j = j;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j++;
			System.out.println(Thread.currentThread().getName()+":"+j);
		}
	}
}
class Thread2 implements Runnable{
	private int j;
	
	public Thread2() {
		super();
	}

	public Thread2(int j) {
		super();
		this.j = j;
	}

	/**
	 * @return the j
	 */
	public int getJ() {
		return j;
	}

	/**
	 * @param j the j to set
	 */
	public void setJ(int j) {
		this.j = j;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j--;
			System.out.println(Thread.currentThread().getName()+":"+j);
		}
	}
}