package com.springmvc.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户信息
 * @author Male
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5671669241081232164L;
	
	private Integer id;
	private String username;
	private String sex;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	// post请求将String--> 日期格式的数据
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")	// 提交json数据时将String--> 日期格式的数据
	private Date brithday;
	private String address;
	

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
				+ address + "]";
	}

	
}
