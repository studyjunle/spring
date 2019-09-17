package com.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jdbc.dao.UserDao;
import com.jdbc.domain.User;
import com.jdbc.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
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

	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

}
