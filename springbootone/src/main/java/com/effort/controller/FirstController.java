package com.effort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//业务逻辑处理类
public class FirstController {
	public FirstController() {

	}
	@RequestMapping(value="/first")
	@ResponseBody
	public  String first() {
		System.out.println("访问first成功");
		return "hello";//默认是跳转到该页面，用@ResponseBody注解标明
	}
 	@RequestMapping("/second")
  	public  void second() {
 		System.out.println("访问second成功");
  		return;
 	}
 	@RequestMapping("/five/{message}")
  	public  void five(@PathVariable String message) {
 		System.out.println("message:"+message);
  		return;
 	}
}
