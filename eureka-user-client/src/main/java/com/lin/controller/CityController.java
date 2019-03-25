package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lin.pojo.City;
import com.lin.service.intf.CityServiceIntl;

@RestController
@EnableEurekaClient
public class CityController {
	@Value("${server.port}")
	String port;
	@Value("${spring.application.name}")
	String serviceName;
	@Autowired
	private CityServiceIntl cityService;
	
	@RequestMapping("getCityById")
	public City getCityById(@RequestParam Long id) {//������в���
		String desc=",,ͨ��client:����Ͷ˿�  "+port+":"+serviceName+"���";
		City city=cityService.findById(id);
		city.setDescription(city.getDescription()+desc);
		return city;
	}
}
