package com.aop.dao.impl;

import org.springframework.stereotype.Service;

import com.aop.dao.UserDao;

@Service("userDao")
public class UserDaoImpl implements UserDao {

	public void addUser() {
		System.out.println("添加用户");
	}

	public void upUser() {
		System.out.println("更新用户");
	}
	
	
}
