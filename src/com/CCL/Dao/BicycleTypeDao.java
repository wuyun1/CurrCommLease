package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.BicycleType;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface BicycleTypeDao {

	BicycleType get(int id);

	List<BicycleType> queryAll();

	void remove(int id);

	void add(BicycleType bicycleType);

	void update(BicycleType bicycleType);

}
