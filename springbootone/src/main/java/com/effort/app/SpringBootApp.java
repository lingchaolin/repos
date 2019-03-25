package com.effort.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//工程启动类
@SpringBootApplication(scanBasePackages={"com.effort.controller"})
//@EnableAutoConfiguration
public class SpringBootApp {

	public SpringBootApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[]args) {
		SpringApplication.run(SpringBootApp.class, args);
		System.out.println("工程启动类");
	}
}
