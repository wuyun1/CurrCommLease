package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OrderState;

public class OrderStateDaoImpl extends BaseDao<OrderState> implements OrderStateDao {
	
	private final static Class mClassName = OrderState.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
