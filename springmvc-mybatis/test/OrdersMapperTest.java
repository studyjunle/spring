package com.springmvc.test;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvc.dao.OrdersMapper;
import com.springmvc.domain.OrdersExt;
import com.springmvc.domain.User;

public class OrdersMapperTest {

private ApplicationContext ctx;
	
	@Before(value = "")
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}


	@Test
	public void testFindOrdersByOneToOne() {
		OrdersMapper mapper = (OrdersMapper) ctx.getBean("ordersMapper");
		List<OrdersExt> findOrdersByOneToOne = mapper.findOrdersByOneToOne();
		for (OrdersExt ordersExt : findOrdersByOneToOne) {
			System.out.println(ordersExt);
		}
	}
	
	@Test
	public void testFindOrdersByOneToOneAboutResultMap() {
		OrdersMapper mapper = (OrdersMapper) ctx.getBean("ordersMapper");
		List<OrdersExt> findOrdersByOneToOne = mapper.findOrdersByOneToOneAboutResultMap();
		for (OrdersExt ordersExt : findOrdersByOneToOne) {
			System.out.println(ordersExt);
		}
	}
	
	@Test
	public void testFindOrdersByOneToManyAboutResultMap() {
		OrdersMapper mapper = (OrdersMapper) ctx.getBean("ordersMapper");
		List<OrdersExt> findOrdersByOneToOne = mapper.findOrdersByOneToManyAboutResultMap();
		for (OrdersExt ordersExt : findOrdersByOneToOne) {
			System.out.println(ordersExt);
		}
	}
	
	@Test
	public void testFindUserAndItemsManyToManyAboutResultMap() {
		OrdersMapper mapper = (OrdersMapper) ctx.getBean("ordersMapper");
		List<User> findOrdersByOneToOne = mapper.findUserAndItemsManyToManyAboutResultMap();
		for (User user : findOrdersByOneToOne) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindOrderAndUserLazyLoading() {
		// 懒加载有bug		在SqlMapConfig.xml文件开启懒加载
		OrdersMapper mapper = (OrdersMapper) ctx.getBean("ordersMapper");
		List<OrdersExt> findOrdersByOneToOne = mapper.findOrderAndUserLazyLoading();
		for (OrdersExt ordersExt : findOrdersByOneToOne) {
			System.out.println(ordersExt.getUser());
		}
	}

}
