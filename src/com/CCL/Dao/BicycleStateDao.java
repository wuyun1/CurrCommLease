package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.BicycleState;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface BicycleStateDao {

	BicycleState get(int id);

	List<BicycleState> queryAll();

	void remove(int id);

	void add(BicycleState bicycleState);

	void update(BicycleState bicycleState);

}
