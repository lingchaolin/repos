/**
 * 
 */
package com.aowin.testspringboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TY
 * create date: 2018年8月22日 上午9:20:17
 */
@EnableAutoConfiguration//   启用Spring应用程序上下文的自动配置，尝试猜测和配置您可能需要的bean
@ComponentScan("com.aowin.testspringboot.controller")
//@ComponentScan 如果不设置basePackage的话 默认会扫描包的所有类，所以最好还是写上basePackage ,减少加载时间。
public class SpringBootApp {

	public SpringBootApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
