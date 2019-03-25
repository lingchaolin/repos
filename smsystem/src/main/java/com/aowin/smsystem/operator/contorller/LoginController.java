/**
 * 
 */
package com.aowin.smsystem.operator.contorller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aowin.smsystem.operator.dao.OperatorDAO;
import com.aowin.smsystem.operator.pojo.Operators;

/**
 * 系统登录和退出需要的处理类
 * @author Administrator
 *
 */
@Controller
public class LoginController {

	/**
	 * 
	 */
	private Logger log=LogManager.getLogger(LoginController.class);
	
	@Autowired
	private OperatorDAO operatordao;
	public LoginController() {
		
	}
	//这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(Operators o,Model m) {
		System.out.println("o:"+o);
		Operators op=operatordao.getoperatorbyusernameandpwd(o);
		System.out.println("op:"+op);
		if(op!=null) {
			m.addAttribute("titleinfo", "登陆成功");
			return "main";
		}else {
			m.addAttribute("operatorinfo", "登陆失败");
			return "index";
		}
	}
	@RequestMapping(value="/quit", method=RequestMethod.POST)
	public String quit(Model m) {
		m.addAttribute("titleinfo", "登陆成功");
		return "??";
	}
}
