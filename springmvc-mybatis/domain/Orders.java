package com.springmvc.domain;

import java.util.Date;
import java.util.List;

/**
 * 订单信息
 * @author Male
 *
 */
public class Orders {

	private Integer id;
	private Integer user_id;
	private String number;
	private Date createtime;
	private String note;
	
	// 一对多		一个订单多个订单详细信息
	private List<Orderdetail> detailList;

	public List<Orderdetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Orderdetail> detailList) {
		this.detailList = detailList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", detailList=" + detailList + "]";
	}

}
