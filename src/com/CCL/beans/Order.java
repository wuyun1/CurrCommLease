package com.CCL.beans;

import java.util.Date;

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
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", opeUser="
				+ opeUser + ", bicycle=" + bicycle + ", orderState="
				+ orderState + ", time=" + time + ", deposit=" + deposit + "]";
	}
	
	
}
