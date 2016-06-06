package com.CCL.Dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	private final static Class mClassName = Order.class;

	
	@Override
	public List<Order> queryByState(OrderState bicycleState) {
		String hql = "from " + mClassName.getName() + " where ORDER_STATE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, bicycleState.getId());
		return query.list();
	}
	


	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}
}
