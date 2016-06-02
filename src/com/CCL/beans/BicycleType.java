package com.CCL.beans;

/**
 * 直行车类别 如 单人车 双人车 等
 * 
 * @author Administrator
 *
 */
public class BicycleType {
	// 编号
	private Integer id;
	// 类别名称
	private String name;
	// 类别描述
	private String descript;
	//自行车折扣
	private Float discount;

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
