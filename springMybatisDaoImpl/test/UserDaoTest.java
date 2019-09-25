package com.mybatis.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;

public class UserDaoTest {

	private ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserByxName() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		List<User> userByxName = userDao.findUserByxName("e");
		for (User u1 : userByxName) {
			System.out.println(u1);
		}
	}

	@Test
	public void testAddUser() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User u2 = new User();
		u2.setUsername("le11111");
		u2.setAddress("广东");
		int add = userDao.addUser(u2);
		System.out.println(u2.getId());
		System.out.println(add);
	}

}
