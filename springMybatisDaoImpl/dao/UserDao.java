package com.mybatis.dao;

import java.util.List;

import com.mybatis.domain.User;

public interface UserDao {
	// 通过用户Id去查询用户信息
	User findUserById(Integer id);
	
	// 通过用户名称模糊查询用户
	List<User> findUserByxName(String username);
	
	// 添加用户
	int addUser(User user);
} 
