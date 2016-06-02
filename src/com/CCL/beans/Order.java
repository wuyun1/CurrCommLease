package com.CCL.beans;

import java.sql.Date;



public class Order {
	
	//	订单ID
	private Integer id;
	//	客户
	private Customer customer;
	// 操作员
	private OpeUser opeUser;
	// 自行车
	private Bicycle bicycle;
	//订单状态
	private OrderState orderState;
	//下单时间
	private Date time;
	//押金
	private Float deposit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OpeUser getOpeUser() {
		return opeUser;
	}
	public void setOpeUser(OpeUser opeUser) {
		this.opeUser = opeUser;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	
	
}
