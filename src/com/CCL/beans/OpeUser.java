package com.CCL.beans;

import java.util.Date;

/**
 * 操作人
 * 
 * @author Jonney
 *
 */
public class OpeUser {
	// 编号
	private Integer id;
	// 用户账号
	private String userName;
	// 密码
	private String password;
	// 薪资
	private Float salary;
	// 姓名
	private String name;
	// 性别
	private String sex;
	// 出生日期
	private Date birthday;
	// 地址
	private String address;
	// 联系电话
	private String phone;
	// 照片
	private String photo;
	// 操作员权限
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

	@Override
	public String toString() {
		return "OpeUser [id=" + id + ", userName=" + userName + ", password="
				+ password + ", salary=" + salary + ", name=" + name + ", sex="
				+ sex + ", birthday=" + birthday + ", address=" + address
				+ ", phone=" + phone + ", photo=" + photo + ", opePer="
				+ opePer + "]";
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
		OpeUser other = (OpeUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
