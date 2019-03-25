package com.aowin.testspringboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //标注主程序类，说明这是一个SpringBoot应用
public class HelloWorld {
	
	public static void main(String[] args) {
		//启动Spring应用
		SpringApplication.run(HelloWorld.class,args);
	}

}
