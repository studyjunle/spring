package com.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserMapper;
import com.springmvc.domain.User;
import com.springmvc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Transactional(readOnly=true)
	public List<User> findAllUser() {
		System.out.println("11111");
		return userMapper.findAllUser();
	}
	
}
