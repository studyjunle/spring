package com.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.dao.UserDao;


public class Test {

	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userService = (UserDao) application.getBean("userDao");
		userService.addUser();
		userService.upUser();
	}

}
