package com.CCL.beans;

import java.sql.Date;



public class Order {
	
	//	����ID
	private Integer id;
	//	�ͻ�
	private Customer customer;
	// ����Ա
	private OpeUser opeUser;
	// ���г�
	private Bicycle bicycle;
	//����״̬
	private OrderState orderState;
	//�µ�ʱ��
	private Date time;
	//Ѻ��
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
