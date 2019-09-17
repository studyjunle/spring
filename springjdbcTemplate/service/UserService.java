package com.jdbc.service;

import java.util.List;

import com.jdbc.domain.User;

public interface UserService {
	
	// 添加用户
	int addUser(User user);

	// 通过id删除用户
	int deleteUser(int id);

	// 修改用户
	int updateUser(User user);

	// 查询所有用户
	List<User> findAllUser();

	// 通过id查找用户
	User findUserById(int id);
}
