package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Bill;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface BillDao {

	Bill get(int id);

	List<Bill> queryAll();

	void remove(int id);

	void add(Bill bill);

	void update(Bill bill);

}
