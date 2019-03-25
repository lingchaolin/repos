package com.effort.IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTwo {
	@Bean("BigCar")
	public Car getLittleCar() {
		return new BigCar();
	}
}
