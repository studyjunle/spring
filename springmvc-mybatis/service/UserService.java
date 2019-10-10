package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.User;

public interface UserService {

	// 查询所有用户
	List<User> findAllUser();

}
