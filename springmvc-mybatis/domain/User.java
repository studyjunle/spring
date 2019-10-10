package com.springmvc.domain;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 * @author Male
 *
 */
public class User {
	private Integer id;
	private String username;
	private String sex;
	private Date brithday;
	private String address;
	
	// 一对多			一个用户多个订单
	private List<Orders> orders;
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", brithday=" + brithday + ", address="
				+ address + ", orders=" + orders + "]";
	}
	
}
