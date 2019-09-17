package com.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jdbc.dao.UserDao;
import com.jdbc.domain.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	// 增
	public int addUser(User user) {
		String sql = "insert into user values (?, ?, ?)";
		return this.getJdbcTemplate().update(sql, user.getId(), user.getUsername(), user.getPassword());
	}

	// 删
	public int deleteUser(int id) {
		String sql = "delete from user where id = ?";
		return this.getJdbcTemplate().update(sql, id);
	}

	// 改
	public int updateUser(User user) {
		String sql = "update user set username = ?, password = ? where id = ?";
		return this.getJdbcTemplate().update(sql, user.getUsername(), user.getPassword(), user.getId());
	}

	// 查
	public List<User> findAllUser() {
		String sql = "select * from user";
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
	}

	// 通过id查询
	public User findUserById(int id) {
		String sql = "select * from user where id = ?";
		return this.getJdbcTemplate().query(sql, new UserRowMapper(), id).get(0);
	}
	
	// 内部私有类
	private class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}

}
