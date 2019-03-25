package com.effort.IOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BuildCar {
	public static void main(String[]args) {
		AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(ConfigSum.class);
		//加载配置--getBean
		Car lcar=(Car) con.getBean("littleCar");
		lcar.printCar();
	}
}
