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
	
	
}
