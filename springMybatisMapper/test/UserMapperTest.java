package com.mybatis.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.dao.UserMapper;
import com.mybatis.domain.User;
import com.mybatis.domain.UserQueryVO;

public class UserMapperTest {

	private ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}


	@Test
	public void testFindUserById() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User user = userMapper.findUserById(41);
		System.out.println(user);
	}

	@Test
	public void testAddUser() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User u2 = new User();
		u2.setUsername("mybatis测试");
		u2.setAddress("广东");
		int add = userMapper.addUser(u2);
		System.out.println(u2.getId());
		System.out.println(add);
	}

	@Test
	public void testFindAllUser() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		List<User> findAllUser = userMapper.findAllUser();
		for (User user : findAllUser) {
			System.out.println(user);
		}
	}

	@Test
	public void testDeleteUserById() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		int deleteUserById = userMapper.deleteUserById(41);
		System.out.println(deleteUserById);
	}

	@Test
	public void testUpdateUser() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User u2 = new User();
		u2.setUsername("结果日哦覅OA111111111111");
		u2.setAddress("广东");
		u2.setId(38);
		int add = userMapper.updateUser(u2);
		System.out.println(u2.getId());
		System.out.println(add);
	}

	@Test
	public void testFindUserList() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		UserQueryVO userQueryVO = new UserQueryVO();
		
		User user1 = new User();
		user1.setUsername("张");
		user1.setSex("1");
		userQueryVO.setUser(user1);
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(10);
		idList.add(30);
		userQueryVO.setIdList(idList);
		List<User> findUserList = userMapper.findUserList(userQueryVO);
		for (User user : findUserList) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindUserCount() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		UserQueryVO userQueryVO = new UserQueryVO();
		// User user = new User();
		// user.setUsername("张");
		// user.setSex("1");
		// userQueryVO.setUser(user);
		int findUserCount = userMapper.findUserCount(userQueryVO);
		System.out.println(findUserCount);
	}

	@Test
	public void testFindUserByIdByMap() {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User userByIdByMap = userMapper.findUserByIdByMap(10);
		System.out.println(userByIdByMap);
	}

}