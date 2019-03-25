package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lin.pojo.User;
import com.lin.service.intf.UserServiceIntl;

@SpringBootApplication
@EnableEurekaClient
public class UserController {

	@Autowired
	private UserServiceIntl userService;
	@RequestMapping()
    public User getUserByName (@RequestParam String name){

        User user = userService.findByName(name);
        return user;
    }
}
