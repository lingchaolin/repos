package com.aowin.Threading;
/**
 * �̰߳�ȫ������
 * ����̹߳���ͬһ�������е����ݣ������ͳһ�����ݲ�����������
 * --���ܻᵼ����������
 * ͬ��������
 * 1.ͬ�������
 * 2.ͬ������
 * 
 * �����ͬ�����ܻᵼ��������
 * ��������ʹ��ͬ��Ƕ�ף�������ʹ�ã�Ҫ������ͬ����˳��
 */
public class FourthSaleTicket {

	public static void main(String[] args) {
		Station2 sta=new Station2();
		Thread t1=new Thread(sta);
		Thread t2=new Thread(sta);
		Thread t3=new Thread(sta);
		t1.setName("��վ");
		t2.setName("app");
		t3.setName("��ţ");
		t1.start();
		t2.start();
		t3.start();
	//���ݲ�һ��
	}

}
class Station implements Runnable{
	int num=6;
	@Override
	public void run() {
		while(true) {
			if(num>0) {
				num--;
				System.out.println(Thread.currentThread().getName()+"����һ��Ʊ,ʣ��:"+num);
			}
		}
	}
}

/**
  *ʵ��ͬ�������ַ�ʽ��
  *1.ʹ��ͬ�������
  *�κζ��󶼿�����Ϊ��������һ������ֻ��һ��Կ�׻�ȡԿ�׵��߳�ִ�У�ִ����ὫԿ�׻�������
  *synchronized()�����Ǳ������ݲ������ʣ�ֻ�Ǳ�֤ͬһʱ��ֻ��һ���߳������С�
  */
class Station2 implements Runnable{
	int num=6;
	@Override
	public void run() {
		//ʹ��ͬ�������
		synchronized(this) {//��Ϊ���ﴦ��Ķ�����Station2����������this����
			while(true) {
//				if(num>0) {
//					num--;
//					System.out.println(Thread.currentThread().getName()+"����һ��Ʊ,ʣ��:"+num);
//				}
				test();
			}
		}
	}
	public synchronized void test() {
		if(num>0) {
			num--;
			System.out.println(Thread.currentThread().getName()+"����һ��Ʊ,ʣ��:"+num);
		}
	}
}
/**


/**ͬ������
	class ����{
		public synchonized �������� ��������(){
			......
		}
	}
 */