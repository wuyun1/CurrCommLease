package com.CCL.beans;

/**
 * ����ԱȨ��
 * @author Jonney
 *
 */
public class Opeper {
	//id
	private Integer id;
	//����Աid
	private OpeUser opeUser;
	//����
	private int toChange =1;
	//�˵���ӡ
	private int billPrint=1;
	//���ֶһ�
	private int pointsFor=1;
	//��Ա������	
	private int upgrade=1;
	//��Ա������
	private int reCard=1;
	//��Ա����ֵ
	private int cardTopup=1;
	//����ѯ
	private int moneyQuery=1;
	//��Ϣ�޸�
	private int reInfo=1;
	//���Ѽ�¼��ѯ
	private int reCordQuery=1;
	//�շ�����
	private int chargingSet=1;
	//�ۿ�����
	private int discountSet=1;
	//��������
	private int carManager=1;
	//���ݱ���
	private int dataBackup=1;
	//��Ϣ����
	private int messageTel=1;
	//��Ӫҵ��ѯ
	private int tradingQuery = 1;
	//�˵���ϸ��ѯ
	private int billDetails = 1;
	
	
	public Opeper() {
		super();
	}

	public Opeper(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OpeUser getOpeUser() {
		return opeUser;
	}

	public void setOpeUser(OpeUser opeUser) {
		this.opeUser = opeUser;
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
		Opeper other = (Opeper) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	public int getTradingQuery() {
		return tradingQuery;
	}

	public void setTradingQuery(int tradingQuery) {
		this.tradingQuery = tradingQuery;
	}

	public int getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(int billDetails) {
		this.billDetails = billDetails;
	}

	public Opeper(OpeUser opeUser, int toChange, int billPrint, int pointsFor, int upgrade, int reCard, int cardTopup,
			int moneyQuery, int reInfo, int reCordQuery, int chargingSet, int discountSet, int carManager,
			int dataBackup, int messageTel, int tradingQuery, int billDetails) {
		super();
		this.opeUser = opeUser;
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
		this.tradingQuery = tradingQuery;
		this.billDetails = billDetails;
	}


	
	
	
}
