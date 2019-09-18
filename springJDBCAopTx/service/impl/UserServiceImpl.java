package com.jdbc.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.dao.UserDao;
import com.jdbc.domain.User;
import com.jdbc.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	public int addUser(User user) {
		return userDao.addUser(user);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Transactional(readOnly = true)
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Transactional(readOnly = true)
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	/**
	 * 转账业务
	 * 表的引擎必须是Innodb（有事务安全的）,否则无法实现事务回滚
	 */
	public int transfer(String outName, String inName, int money) {
		System.out.println("转账中....");
		userDao.out(outName, money);
		//int i = 1 / 0;
		userDao.in(inName, money);
		return 2;
	}

}
