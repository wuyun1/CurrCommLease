package com.CCL.beans;

/**
 * ���г�ʵ����
 * 
 * @author Jonney
 *
 */
public class Bicycle {

	// ֱ�г�ID��
	private Integer id;
	// ֱ�г�״̬
	private BicycleState state;
	// ֱ�г����
	private BicycleType type;
	// ����
	private String name;
	// ����
	private String descript;
	// �۸�
	private Integer price;
	// ���
	private Integer inventory;
	// ����
	private String factory;
	// �Ƿ����
	private Integer isDaZhe;
	// �Ƿ�μӻ���
	private Integer isJiFen;

	
	
	

	public BicycleState getState() {
		return state;
	}

	public void setState(BicycleState state) {
		this.state = state;
	}

	public BicycleType getType() {
		return type;
	}

	public void setType(BicycleType type) {
		this.type = type;
	}

	public Bicycle() {
	}

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
		return state;
	}

	public void setBicycleState(BicycleState bicycleState) {
		this.state = bicycleState;
	}

	public BicycleType getBicycleType() {
		return type;
	}

	public void setBicycleType(BicycleType bicycleType) {
		this.type = bicycleType;
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
		return id.toString();
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
		Bicycle other = (Bicycle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
