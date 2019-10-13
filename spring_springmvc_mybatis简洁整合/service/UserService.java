package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.User;

public interface UserService {

	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 通过Id查找用户
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	
	/**
	 * 通过用户名模糊查询
	 * @param username
	 * @return
	 */
	List<User> findUserByName(String username);
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 通过Id更新用户信息
	 * @param user	里面包含Id
	 * @return
	 */
	int updateUserById(User user);
	
	/**
	 * 通过Id删除用户
	 * @param id
	 */
	int deleteUserById(Integer id);
	
	/**
	 * 注解开发之查找所有用户
	 * @return
	 */
	List<User> findAllUsers();
	
	/**
	 * 注解开发之通过Id查找用户
	 * @param id
	 * @return
	 */
	User findUserByIds(Integer id);
	
	/**
	 * 注解开发之通过用户名模糊查询
	 * @param username
	 * @return
	 */
	List<User> findUserByNames(String username);
	
	/**
	 * 注解开发之增加用户
	 * @param user
	 * @return
	 */
	int addUsers(User user);
	
	/**
	 * 注解开发之通过Id更新用户信息
	 * @param user	里面包含Id
	 * @return
	 */
	int updateUserByIds(User user);
	
	/**
	 * 注解开发之通过Id删除用户
	 * @param id
	 * @return
	 */
	int deleteUserByIds(Integer id);
}
