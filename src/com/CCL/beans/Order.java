package com.CCL.beans;

import java.util.Date;

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
	private Date putTime;
	//����ʱ��
	private Date startTime;
	//����ʱ��
	private Date stopTime;
	//Ѻ��
	private Float deposit;
	
	
	
	public Order() {
		super();
	}

	public Order(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", opeUser=" + opeUser + ", bicycle=" + bicycle
				+ ", orderState=" + orderState + ", putTime=" + putTime + ", startTime=" + startTime + ", stopTime="
				+ stopTime + ", deposit=" + deposit + ", isShow=" + isShow + "]";
	}

	public Order(Customer customer, OpeUser opeUser, Bicycle bicycle, OrderState orderState, Date putTime,
			Date startTime, Date stopTime, Float deposit) {
		super();
		this.customer = customer;
		this.opeUser = opeUser;
		this.bicycle = bicycle;
		this.orderState = orderState;
		this.putTime = putTime;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.deposit = deposit;
	}

	public Date getPutTime() {
		return putTime;
	}

	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	private Boolean isShow = true;
	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}


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
	
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
