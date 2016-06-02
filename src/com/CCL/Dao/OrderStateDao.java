package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OrderState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OrderStateDao {

	OrderState get(int id);

	List<OrderState> queryAll();

	void remove(int id);

	void add(OrderState orderState);

	void update(OrderState orderState);

}
