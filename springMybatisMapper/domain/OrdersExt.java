package com.mybatis.domain;

import java.util.List;

/**
 *  一对一 扩展类 创建扩展类
 * @author Male
 *
 */
public class OrdersExt extends Orders {

	// username 在 orders 类中没有
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	// 用户信息	一对一
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 订单详细信息	一对多
	private List<Orderdetail> detailList;

	public List<Orderdetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Orderdetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "OrdersExt [username=" + username + ", user=" + user + ", detailList=" + detailList + "]";
	}
	
	
}
