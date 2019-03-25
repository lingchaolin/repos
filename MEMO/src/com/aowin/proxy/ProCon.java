package com.aowin.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class ProCon {
	public static void main(String[] args) throws FileNotFoundException {
	/*	Good good = new Good();
		Consumer c1 = new Consumer();
		c1.g = good;
		Producer p1 = new Producer();
		p1.g = good;
		Thread consumer = new Thread(c1);
		Thread producer = new Thread(p1);
		consumer.start();
		producer.start();*/
		String srcStr="D:\\test2.txt";
		PrintWriter pw=new PrintWriter(
				new FileOutputStream(
						new File(srcStr)));
		pw.write("test");
		pw.write("finish");
		pw.flush();
		System.out.println("finish");
	}
}

class Consumer implements Runnable {
	Good g;
	Random random = new Random();

	@Override
	public void run() {
		while (true) {
			synchronized (g) {
				try {
					if (g.getNum() < 50) {
						System.err.println("¿â´æ²»×ã£¬Í£Ö¹ÏûºÄ");
						g.wait();
					} else {
						System.out.print("¿â´æ£º" + g.getNum());
						g.reduce(random.nextInt(30)+1);
						System.out.println("-->¿â´æ£º" + g.getNum());
						g.notify();
					}
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Producer implements Runnable {
	Good g;
	Random random = new Random();

	@Override
	public void run() {
		while (true) {
			synchronized (g) {
				try {
					if (g.getNum() > 200) {
						System.err.println("¿â´æ¹ý¶à£¬Í£Ö¹Éú²ú");
						g.wait();
					} else {
						System.out.print("¿â´æ£º" + g.getNum());
						g.add(random.nextInt(30)+1);
						System.out.println("-->¿â´æ£º" + g.getNum());
						g.notify();
					}
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Good {
	private int num;

	public Good() {
		super();
	}

	public Good(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void add(int no) {
		num += no;
	}

	public void reduce(int no) {
		num -= no;
	}
}