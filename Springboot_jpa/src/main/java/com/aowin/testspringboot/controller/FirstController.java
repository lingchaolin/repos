/**
 * 
 */
package com.aowin.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TY
 * create date: 2018��8��22�� ����9:14:48
 */
@Controller
public class FirstController {

	public FirstController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �÷����ķ��صĽ��ֱ��д�� HTTP ��Ӧ���ģ�ResponseBody���У�һ�����첽��ȡ����ʱʹ�ã�
	 * ͨ������ʹ�� @RequestMapping �󣬷���ֵͨ������Ϊ��ת·�������� @Responsebody 
	 * �󷵻ؽ�����ᱻ����Ϊ��ת·��������ֱ��д��HTTP ��Ӧ�����С� 
	 * @return
	 */
	@RequestMapping(value="/first")
	@ResponseBody
	public String first() {
		return "hello world";
	}

}
