package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Bill;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface BillDao {

	Bill get(int id);

	List<Bill> queryAll();

	void remove(int id);

	void add(Bill bill);

	void update(Bill bill);

}
