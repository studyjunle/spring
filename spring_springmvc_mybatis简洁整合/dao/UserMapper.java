package com.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springmvc.entity.User;

/**
 * 简单的增删改查
 * @author Male
 */
public interface UserMapper {

	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> selectAllUser();
	
	/**
	 * 通过Id查找用户
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);
	
	/**
	 * 通过用户名模糊查询
	 * @param username
	 * @return
	 */
	List<User> selectUserByName(String username);
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	
	/**
	 * 通过Id更新用户信息
	 * @param user	里面包含Id
	 * @return
	 */
	int updateUserById(User user);
	
	/**
	 * 通过Id删除用户
	 * @param id
	 * @return
	 */
	int deleteUserById(Integer id);
	
	/**
	 * 注解开发之查找所有用户
	 * @return
	 */
	@Select("select * from user")
	List<User> selectAllUsers();
	
	/**
	 * 注解开发之通过Id查找用户
	 * @param id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	User selectUserByIds(Integer id);
	
	/**
	 * 注解开发之通过用户名模糊查询
	 * @param username
	 * @return
	 */
	@Select("select * from user where username like'%${value}%'")
	List<User> selectUserByNames(String username);
	
	/**
	 * 注解开发之增加用户
	 * @param user
	 * @return
	 */
	@Insert("insert into user(username, sex, brithday, address) values(#{username}, #{sex}, #{brithday}, #{address})")
	int insertUsers(User user);
	
	/**
	 * 注解开发之通过Id更新用户信息
	 * @param user	里面包含Id
	 * @return
	 */
	@Update("update user set username = #{username}, sex = #{sex}, brithday = #{brithday}, address = #{address} where id = #{id}")
	int updateUserByIds(User user);
	
	/**
	 * 注解开发之通过Id删除用户
	 * @param id
	 * @return
	 */
	@Delete("delete from user where id = #{id}")
	int deleteUserByIds(Integer id);
}
