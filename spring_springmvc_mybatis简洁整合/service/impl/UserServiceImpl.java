package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserMapper;
import com.springmvc.entity.User;
import com.springmvc.service.UserService;

/**
 * 业务层
 * @author Male
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findUserByName(String username) {
		return userMapper.selectUserByName(username);
	}

	@Override
	public int addUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int updateUserById(User user) {
		return userMapper.updateUserById(user);
	}

	@Override
	public int deleteUserById(Integer id) {
		return userMapper.deleteUserById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userMapper.selectAllUsers();
	}

	@Override
	public User findUserByIds(Integer id) {
		return userMapper.selectUserByIds(id);
	}

	@Override
	public List<User> findUserByNames(String username) {
		return userMapper.selectUserByNames(username);
	}

	@Override
	public int addUsers(User user) {
		return userMapper.insertUsers(user);
	}

	@Override
	public int updateUserByIds(User user) {
		return userMapper.updateUserByIds(user);
	}

	@Override
	public int deleteUserByIds(Integer id) {
		return userMapper.deleteUserByIds(id);
	}

}
