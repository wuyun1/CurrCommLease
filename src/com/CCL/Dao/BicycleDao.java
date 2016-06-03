package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface BicycleDao {

	Bicycle get(int id);

	List<Bicycle> queryAll();

	void remove(int id);

	void add(Bicycle bicycle);

	void update(Bicycle bicycle);
	
	//ͨ�������ѯ
	List<Bicycle> queryByExample(Bicycle instance);

}
