package com.CCL.beans;

/**
 * ֱ�г���� �� ���˳� ˫�˳� ��
 * 
 * @author Administrator
 *
 */
public class BicycleType {
	// ���
	private Integer id;
	// �������
	private String name;
	// �������
	private String descript;
	//���г��ۿ�
	private Float discount;
	
	private Boolean isShow = true;
	
	
	public BicycleType(Integer id) {
		super();
		this.id = id;
	}

	public BicycleType(String name, String descript, Float discount) {
		super();
		this.name = name;
		this.descript = descript;
		this.discount = discount;
	}

	public BicycleType() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BicycleType other = (BicycleType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescript() {
		return descript;
	}

	public Float getDiscount() {
		return discount;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}

	
	
}
