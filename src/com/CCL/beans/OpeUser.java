package com.CCL.beans;

import java.util.Date;

/**
 * ������
 * 
 * @author Jonney
 *
 */
public class OpeUser {
	// ���
	private Integer id;
	// �û��˺�
	private String userName;
	// ����
	private String password;
	// н��
	private Float salary;
	// ����
	private String name;
	// �Ա�
	private String sex;
	// ��������
	private Date birthday;
	// ��ַ
	private String address;
	// ��ϵ�绰
	private String phone;
	// ��Ƭ
	private String photo;
	// ����ԱȨ��
	private Opeper opePer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUser(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Opeper getOpePer() {
		return opePer;
	}

	public void setOpePer(Opeper opePer) {
		this.opePer = opePer;
	}

}
