package com.springmvc.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCustomer {

	private User user;
	
	private List<User> userList;
	
	// 开发习惯 	定义map类型要new一new
	private Map<String, Object> userMap = new HashMap<String, Object>();
	

	public Map<String, Object> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserCustomer [user=" + user + ", userList=" + userList + ", userMap=" + userMap + "]";
	}
	
}
