package com.CCL.beans;

/**
 * 操作员权限
 * @author Jonney
 *
 */
public class Opeper {
	//id
	private Integer id;
	//操作员id
	private Integer oid;
	//换车
	private int toChange;
	//账单打印
	private int billPrint;
	//积分兑换
	private int pointsFor;
	//会员卡升级	
	private int upgrade;
	//会员卡补办
	private int reCard;
	//会员卡充值
	private int cardTopup;
	//余额查询
	private int moneyQuery;
	//信息修改
	private int reInfo;
	//消费记录查询
	private int reCordQuery;
	//收费设置
	private int chargingSet;
	//折扣设置
	private int discountSet;
	//车辆管理
	private int carManager;
	//数据备份
	private int dataBackup;
	//短息提醒
	private int messageTel;
	
	
	
	
	public Opeper() {
		super();
	}

	public Opeper(Integer id) {
		super();
		this.id = id;
	}

	public Opeper(Integer oid, int toChange, int billPrint, int pointsFor, int upgrade, int reCard, int cardTopup,
			int moneyQuery, int reInfo, int reCordQuery, int chargingSet, int discountSet, int carManager,
			int dataBackup, int messageTel) {
		super();
		this.oid = oid;
		this.toChange = toChange;
		this.billPrint = billPrint;
		this.pointsFor = pointsFor;
		this.upgrade = upgrade;
		this.reCard = reCard;
		this.cardTopup = cardTopup;
		this.moneyQuery = moneyQuery;
		this.reInfo = reInfo;
		this.reCordQuery = reCordQuery;
		this.chargingSet = chargingSet;
		this.discountSet = discountSet;
		this.carManager = carManager;
		this.dataBackup = dataBackup;
		this.messageTel = messageTel;
	}



	private Boolean isShow = true;
	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public int getToChange() {
		return toChange;
	}
	public void setToChange(int toChange) {
		this.toChange = toChange;
	}
	public int getBillPrint() {
		return billPrint;
	}
	public void setBillPrint(int billPrint) {
		this.billPrint = billPrint;
	}
	public int getPointsFor() {
		return pointsFor;
	}
	public void setPointsFor(int pointsFor) {
		this.pointsFor = pointsFor;
	}
	public int getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(int upgrade) {
		this.upgrade = upgrade;
	}
	public int getReCard() {
		return reCard;
	}
	public void setReCard(int reCard) {
		this.reCard = reCard;
	}
	public int getCardTopup() {
		return cardTopup;
	}
	public void setCardTopup(int cardTopup) {
		this.cardTopup = cardTopup;
	}
	public int getMoneyQuery() {
		return moneyQuery;
	}
	public void setMoneyQuery(int moneyQuery) {
		this.moneyQuery = moneyQuery;
	}
	public int getReInfo() {
		return reInfo;
	}
	public void setReInfo(int reInfo) {
		this.reInfo = reInfo;
	}
	public int getReCordQuery() {
		return reCordQuery;
	}
	public void setReCordQuery(int reCordQuery) {
		this.reCordQuery = reCordQuery;
	}
	public int getChargingSet() {
		return chargingSet;
	}
	public void setChargingSet(int chargingSet) {
		this.chargingSet = chargingSet;
	}
	public int getDiscountSet() {
		return discountSet;
	}
	public void setDiscountSet(int discountSet) {
		this.discountSet = discountSet;
	}
	public int getCarManager() {
		return carManager;
	}
	public void setCarManager(int carManager) {
		this.carManager = carManager;
	}
	public int getDataBackup() {
		return dataBackup;
	}
	public void setDataBackup(int dataBackup) {
		this.dataBackup = dataBackup;
	}
	public int getMessageTel() {
		return messageTel;
	}
	public void setMessageTel(int messageTel) {
		this.messageTel = messageTel;
	}
	@Override
	public String toString() {
		return "Opeper [id=" + id + ", oid=" + oid + ", toChange=" + toChange
				+ ", billPrint=" + billPrint + ", pointsFor=" + pointsFor
				+ ", upgrade=" + upgrade + ", reCard=" + reCard
				+ ", cardTopup=" + cardTopup + ", moneyQuery=" + moneyQuery
				+ ", reInfo=" + reInfo + ", reCordQuery=" + reCordQuery
				+ ", chargingSet=" + chargingSet + ", discountSet="
				+ discountSet + ", carManager=" + carManager + ", dataBackup="
				+ dataBackup + ", messageTel=" + messageTel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billPrint;
		result = prime * result + carManager;
		result = prime * result + cardTopup;
		result = prime * result + chargingSet;
		result = prime * result + dataBackup;
		result = prime * result + discountSet;
		result = prime * result + messageTel;
		result = prime * result + moneyQuery;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + pointsFor;
		result = prime * result + reCard;
		result = prime * result + reCordQuery;
		result = prime * result + reInfo;
		result = prime * result + toChange;
		result = prime * result + upgrade;
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
		Opeper other = (Opeper) obj;
		if (billPrint != other.billPrint)
			return false;
		if (carManager != other.carManager)
			return false;
		if (cardTopup != other.cardTopup)
			return false;
		if (chargingSet != other.chargingSet)
			return false;
		if (dataBackup != other.dataBackup)
			return false;
		if (discountSet != other.discountSet)
			return false;
		if (messageTel != other.messageTel)
			return false;
		if (moneyQuery != other.moneyQuery)
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (pointsFor != other.pointsFor)
			return false;
		if (reCard != other.reCard)
			return false;
		if (reCordQuery != other.reCordQuery)
			return false;
		if (reInfo != other.reInfo)
			return false;
		if (toChange != other.toChange)
			return false;
		if (upgrade != other.upgrade)
			return false;
		return true;
	}
	
	
	
}
