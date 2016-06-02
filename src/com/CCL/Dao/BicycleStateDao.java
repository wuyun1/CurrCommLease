package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.BicycleState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface BicycleStateDao {

	BicycleState get(int id);

	List<BicycleState> queryAll();

	void remove(int id);

	void add(BicycleState bicycleState);

	void update(BicycleState bicycleState);

}
