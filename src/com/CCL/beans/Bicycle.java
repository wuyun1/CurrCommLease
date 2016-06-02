package com.CCL.beans;

/**
 * 自行车实体类
 * 
 * @author Jonney
 *
 */
public class Bicycle {

	// 直行车ID号
	private Integer id;
	// 直行车状态
	private BicycleState bicycleState;
	// 直行车类别
	private BicycleType bicycleType;
	// 名称
	private String name;
	// 描述
	private String descript;
	// 价格
	private Integer price;
	// 库存
	private Integer inventory;
	// 厂商
	private String factory;
	// 是否打折
	private Integer isDaZhe;
	// 是否参加积分
	private Integer isJiFen;

	
	
	
	public Integer getIsDaZhe() {
		return isDaZhe;
	}

	public void setIsDaZhe(Integer isDaZhe) {
		this.isDaZhe = isDaZhe;
	}

	public Integer getIsJiFen() {
		return isJiFen;
	}

	public void setIsJiFen(Integer isJiFen) {
		this.isJiFen = isJiFen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BicycleState getBicycleState() {
		return bicycleState;
	}

	public void setBicycleState(BicycleState bicycleState) {
		this.bicycleState = bicycleState;
	}

	public BicycleType getBicycleType() {
		return bicycleType;
	}

	public void setBicycleType(BicycleType bicycleType) {
		this.bicycleType = bicycleType;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", bicycleState=" + bicycleState + ", bicycleType=" + bicycleType + ", name="
				+ name + ", descript=" + descript + ", price=" + price + ", inventory=" + inventory + ", factory="
				+ factory + "]";
	}

}
