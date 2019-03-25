package com.effort.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//业务逻辑处理类
public class SecondController {
	public SecondController() {

	}
	@RequestMapping(value="/third")
	public  String third() {
		System.out.println("访问third成功");
		return "hello";//默认是跳转到该页面，用@ResponseBody注解标明
	}
 	@RequestMapping("/fourth/{message}")
  	public  void fourth(@PathVariable String message) {
 		System.out.println("message:"+message);
  		return;
 	}
}
