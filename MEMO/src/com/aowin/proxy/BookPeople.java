package com.aowin.proxy;

public class BookPeople implements Book{
	@Override
	public void findBook() {
		System.out.println("BookPeople.findBook:�����������");
	}
	@Override
	public void checkBook() {
		System.out.println("BookPeople.checkBook:�������ȷ����");
	}
	@Override
	public void buyBook() {
		System.out.println("BookPeople.buyBook:������˸���");
	}
}
