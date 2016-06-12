package com.CCL.beans;

import java.util.Date;

/**
 * �˵���
 * 
 * @author Administrator
 *
 */
public class Bill {

	// �˵����
	private Integer id;
	// ����ʱ��
	private Date outTime;
	// ����ʱ�� (����)
	private Long delay;
	
	// �����Ķ���
	private Order order;
	// �ͻ�����   û�й���Լ��
	private String customerName;
	// �ͻ�ID   û�й���Լ��
	private Integer customerId;
	// ���˷�ʽ
	private String payWay;
	// �ܽ��
	private float total;
	
	private Boolean isShow = true;
	
	

	public Bill(Integer id) {
		super();
		this.id = id;
	}

	public Bill(Date outTime, Long delay, Order order, String customerName, Integer customerId, String payWay,
			float total) {
		super();
		this.outTime = outTime;
		this.delay = delay;
		this.order = order;
		this.customerName = customerName;
		this.customerId = customerId;
		this.payWay = payWay;
		this.total = total;
	}

	public Bill() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Bill [id=" + id + ", outTime=" + outTime + ", delay=" + delay + ", order=" + order + ", customerName="
				+ customerName + ", payWay=" + payWay + ", total=" + total + ", isShow=" + isShow + "]";
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
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


}
