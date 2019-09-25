package com.mybatis.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	public User findUserById(Integer id) {
		return this.getSqlSession().selectOne("dao.findUserById", id);
	}

	public List<User> findUserByxName(String username) {
		return this.getSqlSession().selectList("dao.findUserByXName", username);
	}

	public int addUser(User user) {
		return this.getSqlSession().insert("dao.addUser", user);
	}

}
