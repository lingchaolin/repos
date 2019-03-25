/**
 * 
 */
package com.aowin.testspringboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TY
 */
@SpringBootApplication(scanBasePackages= {"com.aowin.testspringboot"})
public class SpringBootApp {

	public SpringBootApp() {
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}