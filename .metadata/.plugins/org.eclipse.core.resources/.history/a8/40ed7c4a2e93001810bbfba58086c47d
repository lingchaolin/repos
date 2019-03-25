package com.aowin.Threading;

public class ConsumerTest {

	public static void main(String[] args) {
		Queue q = new Queue(); // 创建，并初始化一个队列
		Producer p = new Producer(q); // 创建，并初始化一个生产者
		Consumer c = new Consumer(q); // 创建，并初始化一个消费者
		c.start(); // 消费者线程启动
		p.start(); // 生产者线程启动
	}
}

//class ThreadCommunication {
//	public static void main(String[] args) {
//		Queue q = new Queue(); // 创建，并初始化一个队列
//		Producer p = new Producer(q); // 创建，并初始化一个生产者
//		Consumer c = new Consumer(q); // 创建，并初始化一个消费者
//		c.start(); // 消费者线程启动
//		p.start(); // 生产者线程启动
//	}
//}

class Queue2 {
	int value = 0; // 声明，并初始化整数类型数据域 value
	boolean isEmpty = true; // 声明，并初始化布尔类型数据域 isEmpty，用于判断队列的状态
	// 生产者生产方法

	public synchronized void put(int v) {
		// 如果共享数据没有被消费，则生产者等待
		if (!isEmpty) {
			try {
				System.out.println("生产者等待");
				wait(); // 进入等待状态
			} catch (Exception e) // 捕获异常
			{
				e.printStackTrace(); // 异常信息输出
			}
		}
		value += v; // value 值加 v
		isEmpty = false; // isEmpty 赋值为 false
		System.out.println("生产者共生产数量：" + v); // 输出字符串信息
		notify(); // 生产之后通知消费者消费
	}

	// 消费者消费的方法
	public synchronized int get() {
		// 消费者消费前，如果共享数据已经被消费完，则消费者等待
		if (isEmpty) {
			try {
				System.out.println("消费者等待"); // 输出字符串信息
				wait(); // 进入等待状态
			} catch (Exception e) // 捕获异常
			{
				e.printStackTrace(); // 异常信息输出
			}
		}
		value--; // value 值-1
		if (value < 1) {
			isEmpty = true; // isEmpty 赋值 true
		}
		System.out.println("消费者消费一个,剩余：" + value); // 输出信息
		notify(); // 消费者消费后,通知生产者生产
		return value; // 返回 value
	}
}