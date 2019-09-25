package com.mybatis.dao;

import java.util.List;

import com.mybatis.domain.User;
import com.mybatis.domain.UserQueryVO;

/**
 * 简单的增删改查
 * @author Male
 *
 */
public interface UserMapper {
	// 通过id查询用户
	User findUserById(Integer id);
	// 添加用户
	int addUser(User user);
	// 查询所有用户
	List<User> findAllUser();
	// 删除用户
	int deleteUserById(Integer id);
	// 更新用户
	int updateUser(User user);
	
	// 综合查询
	List<User> findUserList(UserQueryVO userQueryVO);
	
	// 综合查询 获取用户的总数
	int findUserCount(UserQueryVO userQueryVO);
	
	// 综合查询 通过id查询用户
	User findUserByIdByMap(Integer id);
}
