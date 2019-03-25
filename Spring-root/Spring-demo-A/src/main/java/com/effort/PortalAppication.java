package com.effort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PortalAppication {
	public static void main(String[] args) {
		SpringApplication.run(PortalAppication.class,args);
	}
}
