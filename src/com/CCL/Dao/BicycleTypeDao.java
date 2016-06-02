package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.BicycleType;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface BicycleTypeDao {

	BicycleType get(int id);

	List<BicycleType> queryAll();

	void remove(int id);

	void add(BicycleType bicycleType);

	void update(BicycleType bicycleType);

}
