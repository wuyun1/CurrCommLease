package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OrderState;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OrderStateDao {

	OrderState get(int id);

	List<OrderState> queryAll();

	void remove(int id);

	void add(OrderState orderState);

	void update(OrderState orderState);

}
