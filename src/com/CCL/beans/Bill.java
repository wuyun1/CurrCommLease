package com.CCL.beans;

import java.util.Date;

/**
 * 账单类
 * 
 * @author Administrator
 *
 */
public class Bill {

	// 账单编号
	private Integer id;
	// 结账时间
	private Date outTime;
	// 消费时长 (分钟)
	private Long delay;
	// 结账方式
	private String payWay;
	// 总金额
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
