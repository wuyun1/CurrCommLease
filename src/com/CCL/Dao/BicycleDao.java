package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface BicycleDao {

	Bicycle get(int id);

	List<Bicycle> queryAll();

	void remove(int id);

	void add(Bicycle bicycle);

	void update(Bicycle bicycle);
	
	//通过对象查询
	List<Bicycle> queryByExample(Bicycle instance);

}
