package com.fuckaowin.sms.operator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuckaowin.sms.operator.dao.OperatorDAO;
import com.fuckaowin.sms.operator.pojo.Operators;
@Controller
public class LoginController {
	private Logger logger=LogManager.getLogger(LoginController.class);
	@Autowired
	OperatorDAO operatorDAO;
	public LoginController() {
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String checkLogin(Operators o,Model m) {
		System.out.println("o:"+o);
		Operators op=operatorDAO.getoperatorbyusernameandpwd(o);
		System.out.println("op:"+op);
		System.out.println("M:"+m);
		if(op!=null){
			m.addAttribute("titleinfo","µÇÂ½³É¹¦");
			return  "main";
		}else {
			m.addAttribute("testinfo","µÇÂ¼Ê§°Ü");
			return "index";
		}
	}

}
