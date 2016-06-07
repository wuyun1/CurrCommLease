package com.CCL.view.kaitaimgr.mydao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Collection;

import com.CCL.Dao.BicycleDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class MyBicycleDaoImpl implements BicycleDao {

	static List<Bicycle> bicycles= new ArrayList<Bicycle>();
	
	public MyBicycleDaoImpl() {
		
		BicycleState bs1 = new BicycleState("A","A ״̬");
		BicycleState bs2 = new BicycleState("B","B ״̬");
		BicycleState bs3 = new BicycleState("C","C ״̬");
		
		
		BicycleType bt1 = new BicycleType("A","A ����",0.7f);
		BicycleType bt2 = new BicycleType("B","B ����",0.98f);
		BicycleType bt3 = new BicycleType("C","C ����",0.9f);
		

		Bicycle b1 = new Bicycle(bs3, bt2, "��������", "��������������", 8, 20, "���", 1, 1, 9,5 ,10);
		Bicycle b2 = new Bicycle(bs1, bt1, "�µ�A8", "�µ�A8������", 7, 15, "����", 1, 1, 9,5 ,10);
		Bicycle b3 = new Bicycle(bs2, bt3, "С���糵", "С���糵������", 9, 2, "���", 1, 1, 5,4 ,13);
		
		b1.setId(1);
		b2.setId(2);
		b3.setId(3);
		
		bicycles.add(b1);
		bicycles.add(b2);
		bicycles.add(b3);
		
	}
	@Override
	public Bicycle get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bicycle> queryAll() {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Bicycle> queryByExample(Bicycle instance) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByType(BicycleType bicycleType) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}

	@Override
	public List<Bicycle> queryByState(BicycleState bicycleState) {
		// TODO Auto-generated method stub
		Collections.shuffle(bicycles);
		return bicycles;
	}
	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean add(Bicycle bicycle) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Bicycle bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

}
