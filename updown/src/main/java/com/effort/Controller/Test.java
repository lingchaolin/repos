package com.effort.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	public Test() {
		
	}
	@RequestMapping(value="/inter")
	@ResponseBody
	public String inter() {
		System.out.println("访问方法！");
		return "name:";
	}
}
