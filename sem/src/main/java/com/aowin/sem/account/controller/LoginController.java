package com.aowin.sem.account.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.sem.account.pojo.Scmuser;

@Controller
public class LoginController {
	private Logger logger=LogManager.getLogger(LoginController.class);
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/login")
	public String checkLogin(Scmuser scmuser,Model m) {
		System.out.println("scmuser:"+scmuser);
		System.out.println("okkkkkkk");
		return "index";
	}
}
