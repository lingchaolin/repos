package com.aowin.javabasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyPic {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		Cinema cinema=new Cinema(list,"������");
		new Thread(new Customer(cinema, 1,2,3),"�ͻ�1").start();;
		new Thread(new Customer(cinema, 3,8,9),"�ͻ�2").start();;
	}
}
class Customer implements Runnable{
	Cinema cinema;
	List<Integer> seats;
	public Customer(Cinema cinema, List<Integer>  seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	public Customer(Cinema cinema,Integer...args) {
		super();
		seats=new ArrayList<>();
		this.cinema = cinema;
		for(Integer arr:args) {
			seats.add(arr);
		}
	}
	
	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTicket(seats);
			if(flag) {
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"--seats:"+Arrays.toString(seats.toArray()));
			}else {
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"--seats:"+Arrays.toString(seats.toArray()));
				
			}
		}
	}
}
class Cinema{
	List<Integer>  available;
	String name;
	public Cinema(List<Integer>  available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public boolean bookTicket(List<Integer>  seats) {
		List<Integer> copy=new ArrayList<>();
		copy.addAll(available);
		copy.removeAll(seats);
		if(available.size()-copy.size()!=seats.size()) {
			System.out.println("������λ���Ѿ��۳��������¶���");
			return false;
		}
		available=copy;
//		System.out.println(Arrays.toString(available.toArray()));
		System.out.println(Arrays.toString(seats.toArray())+"����λ�����ɹ�");
		return true;
	}
}