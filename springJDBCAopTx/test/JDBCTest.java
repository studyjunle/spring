package com.jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.domain.User;
import com.jdbc.service.UserService;

public class JDBCTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) application.getBean("userService");
		User user = new User();
		user.setId(6);
		user.setUsername("leE");
		user.setPassword("aaa");
		// 增加
		/*int addUser = userService.addUser(user);
		if (addUser > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}*/
		// 修改
		/*int updateUser = userService.updateUser(user);
		if (updateUser > 0) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}*/
		// 删除
		/*int deleteUser = userService.deleteUser(6);
		if (deleteUser > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}*/
		// 查找所有
		/*List<User> findAllUser = userService.findAllUser();
		for (User u : findAllUser) {
			System.out.println(u);
		}*/
		// 通过id查找用户
		//System.out.println(userService.findUserById(3));
		// 转账业务
		userService.transfer("le", "na", 100);
	}

}
