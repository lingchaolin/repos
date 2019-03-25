package com.effort.IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigOne {//作为容器
	@Bean("littleCar")
	public Car getLittleCar() {
		return new LittleCar();
	}
}
