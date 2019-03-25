package com.aowin.review.rtti;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import javax.security.auth.Subject;

public class ForThread3 {
	public ForThread3() {

	}

	public static void main(String[] args) {
		final BaseOne baseOne=new BaseOne();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 50; i++) {
					baseOne.Subject(i);
				}
				
			}
		}).start();
		for (int i = 1; i <= 50; i++) {
			baseOne.main(i);
		}
	}

}
class BaseOne {
	private boolean flag=true;
	public synchronized void Subject(int i) {
			try {
				while(!flag) {
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int j=0;j<10;j++) {
				System.out.println("main sequence is :" + j + "   main loop is :"
						+ i);
			}
			flag=false;
			this.notify();
	}
	public synchronized void main(int i) {
		try {
			while(flag) {
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int j=0;j<100;j++) {
			System.out.println("main sequence is :" + j + "   main loop is :"
					+ i);
		}
		flag=true;
		this.notify();
	}
}
