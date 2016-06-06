package com.CCL.view.kaitaimgr.mydao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class MyBicycleTypeDaoImpl implements BicycleTypeDao {
	
List<BicycleType> bts= new ArrayList<BicycleType>();
	
	public MyBicycleTypeDaoImpl() {
		
	
		
		
		BicycleType bt1 = new BicycleType("A","A 类型",0.7f);
		BicycleType bt2 = new BicycleType("B","B 类型",0.98f);
		BicycleType bt3 = new BicycleType("C","C 类型",0.9f);
		

	
		
		bts.add(bt1);
		bts.add(bt2);
		bts.add(bt3);
		
	}

	@Override
	public BicycleType get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BicycleType> queryAll() {
		
		
		
		return bts;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	

	@Override
	public List<BicycleType> queryByExample(BicycleType instance) {
		// TODO Auto-generated method stub
		return bts;
	}

	@Override
	public List<BicycleType> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return bts;
	}

	@Override
	public List<BicycleType> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return bts;
	}

	@Override
	public List<BicycleType> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return bts;
	}

	@Override
	public List<BicycleType> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return bts;
	}

	@Override
	public boolean add(BicycleType bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BicycleType bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

}
