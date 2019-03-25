package com.effort.jpatest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.effort.jpatest"})
@EntityScan("com.effort.jpatest.pojo")
@EnableJpaRepositories("com.effort.jpatest.respository")
@EnableCaching
public class SpringBootApp {

	public SpringBootApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
