package com.CCL.service.glj;

import java.util.List;
import java.util.Vector;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BicycleTypeDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;

public class ShouFeiSetService {

	BicycleDao bicycle_dao = new BicycleDaoImpl();
	BicycleTypeDao bicycleTypeDao = new BicycleTypeDaoImpl();
	
	
	//��ѯ���еĳ�����
	public List<BicycleType> getAllBicycleType()
	{
		
		return bicycleTypeDao.queryAll();
	}
	//���ݳ�ID�鳵
	public Bicycle get(int id) {
		return bicycle_dao.get(id);
	}
	//����һ����
	public boolean addBicycle(Bicycle bicycle) {
		return bicycle_dao.add(bicycle);
	}
//�޸�һ����
	public boolean update(Bicycle bicycle) {
		return bicycle_dao.update(bicycle);
	}
	//��ѯ���г�
	public List<Bicycle> getAllBicycleList() {
		
		return bicycle_dao.queryAll();
		
	}
	//���ݳ�����ѯ��
	public List<Bicycle> getAllByLikeName(String name)
	{
		return bicycle_dao.queryByUseLikeAndPage("NAME", name, 20, 0);
		
	}
	
	public Vector<Vector<Object>> getAllBicycle() {
		List<Bicycle> blist = bicycle_dao.queryAll();

		Vector<Vector<Object>> bicycle = new Vector<Vector<Object>>();
		for (int i = 0; i < blist.size(); i++) {
			if (blist.size() > 0) {
				if (blist.get(i) instanceof Bicycle) {
					if (blist.get(i).getIsShow()) {
						Vector<Object> tabbicycle = new Vector<Object>();
						Integer id = blist.get(i).getId();
						BicycleType type = blist.get(i).getType();
						Bicycle name = blist.get(i);
						Integer price = blist.get(i).getPrice();
						Integer basetime = blist.get(i).getBaseTime();
						Integer chargetime = blist.get(i).getChargeTime();
						Integer overtimeprice = blist.get(i).getOverTimePrice();
						String isdazhe = "��";
						String isjifen = "��";
						System.out.println("fgdg" + blist.get(i).getIsDaZhe()
								+ id);
						if (blist.get(i).getIsDaZhe() == 1) {
							isdazhe = "�μ�";
						}
						if (blist.get(i).getIsJiFen() == 1) {
							isjifen = "�μ�";
						}
						Float zhekou = type.getDiscount();

						tabbicycle.add(i + 1);
						tabbicycle.add(type);
						tabbicycle.add(name);
						tabbicycle.add(price);
						tabbicycle.add(basetime);
						tabbicycle.add(chargetime);
						tabbicycle.add(price);
						tabbicycle.add(overtimeprice);

						tabbicycle.add(isjifen);
						tabbicycle.add(isdazhe);
						tabbicycle.add(zhekou);
						bicycle.add(tabbicycle);
					}
				}
			}
		}
		return bicycle;
	}
}
