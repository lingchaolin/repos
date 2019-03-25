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
		Cinema cinema=new Cinema(list,"新世纪");
		new Thread(new Customer(cinema, 1,2,3),"客户1").start();;
		new Thread(new Customer(cinema, 3,8,9),"客户2").start();;
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
				System.out.println("出票成功"+Thread.currentThread().getName()+"--seats:"+Arrays.toString(seats.toArray()));
			}else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"--seats:"+Arrays.toString(seats.toArray()));
				
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
			System.out.println("部分座位号已经售出，请重新订购");
			return false;
		}
		available=copy;
//		System.out.println(Arrays.toString(available.toArray()));
		System.out.println(Arrays.toString(seats.toArray())+"号座位订购成功");
		return true;
	}
}