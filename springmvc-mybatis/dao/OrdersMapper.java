package com.springmvc.dao;

import java.util.List;

import com.springmvc.domain.OrdersExt;
import com.springmvc.domain.User;

/**
 * 对象之间的映射关系
 * @author Male
 *
 */
public interface OrdersMapper {
	
	// 一对一 		resultType
	List<OrdersExt> findOrdersByOneToOne();
	// 一对一		resultMap
	List<OrdersExt> findOrdersByOneToOneAboutResultMap();
	
	// 一对多		resultMap
	List<OrdersExt> findOrdersByOneToManyAboutResultMap();
	
	// 多对多		resultMap  应该写到UserMapper中去，但是在将对象与对象之间的关系才放在这里
	List<User> findUserAndItemsManyToManyAboutResultMap();
	
	// 懒加载
	List<OrdersExt> findOrderAndUserLazyLoading();
	
}
