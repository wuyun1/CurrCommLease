package com.CCL.beans;

import java.util.Date;

public class Customer {
	//	�ͻ�ID
	private Integer id;
	//	�ͻ�״̬
	private CustomerState customerState;
	//	�ͻ����
	private CustomerType customerType;
	//	�ͻ�����
	private String name;
	//	�Ա�
	private String sex;
	//	��������
	private Date birthday;
	//	��ϵ�绰
	private String phone;
	//	����
	private String email;
	//	סַ
	private String address;
	// ����
	private String integral;
	// ���
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
