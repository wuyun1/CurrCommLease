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
	// ���˷�ʽ
	private String payWay;
	// �ܽ��
	private float total;

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

}
