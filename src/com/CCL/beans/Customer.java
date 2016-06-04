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
	// ����
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//	��ϵ�绰
	private String phone;
	//	����
	private String email;
	//	סַ
	private String address;
	// ����
	private Integer integral;
	// ���
	private Float money;
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
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerState=" + customerState + ", customerType=" + customerType + ", name="
				+ name + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", integral=" + integral + ", money=" + money + "]";
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
