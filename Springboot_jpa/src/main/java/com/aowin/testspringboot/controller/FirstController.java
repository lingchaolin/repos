/**
 * 
 */
package com.aowin.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TY
 * create date: 2018年8月22日 上午9:14:48
 */
@Controller
public class FirstController {

	public FirstController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中，一般在异步获取数据时使用，
	 * 通常是在使用 @RequestMapping 后，返回值通常解析为跳转路径，加上 @Responsebody 
	 * 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。 
	 * @return
	 */
	@RequestMapping(value="/first")
	@ResponseBody
	public String first() {
		return "hello world";
	}

}
