package com.springmvc.domain;

/**
 * 订单详细信息
 * @author Male
 *
 */
public class Orderdetail {
	private Integer id;
	private Integer orders_id;
	private Integer items_id;
	private Integer items_num;
	
	// 一对一		一个订单详细信息对应一个商品
	private Items items;
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}

	public Integer getItems_id() {
		return items_id;
	}

	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}

	public Integer getItems_num() {
		return items_num;
	}

	public void setItems_num(Integer items_num) {
		this.items_num = items_num;
	}

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", orders_id=" + orders_id + ", items_id=" + items_id + ", items_num="
				+ items_num + ", items=" + items + "]";
	}

}
