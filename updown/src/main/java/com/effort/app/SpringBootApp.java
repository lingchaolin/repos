package com.effort.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages= {"com.effort.Controller"})
public class SpringBootApp {

	public SpringBootApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
		System.out.println("springboot启动！");
	}

}
