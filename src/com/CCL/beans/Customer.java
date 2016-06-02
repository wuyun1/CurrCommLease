package com.CCL.beans;

import java.util.Date;

public class Customer {
	//	客户ID
	private Integer id;
	//	客户状态
	private CustomerState customerState;
	//	客户类别
	private CustomerType customerType;
	//	客户姓名
	private String name;
	//	性别
	private String sex;
	//	出生日期
	private Date birthday;
	//	联系电话
	private String phone;
	//	邮箱
	private String email;
	//	住址
	private String address;
	// 积分
	private String integral;
	// 余额
	private String money;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerState getCustomerState() {
		return customerState;
	}
	public void setCustomerState(CustomerState customerState) {
		this.customerState = customerState;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntegral() {
		return integral;
	}
	public void setIntegral(String integral) {
		this.integral = integral;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	
	
}
