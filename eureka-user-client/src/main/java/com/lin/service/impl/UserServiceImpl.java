package com.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.UserDao;
import com.lin.pojo.User;
import com.lin.service.intf.UserServiceIntl;

@Service
public class UserServiceImpl implements UserServiceIntl{

	@Autowired
	private UserDao userDao;
	public User findByName(String name) {
		return userDao.findByName(name);
	}
}
