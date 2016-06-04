package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.CustomerType;

public class CustomerTypeDaoImpl extends BaseDao<CustomerType> implements CustomerTypeDao {

	private final static Class mClassName = CustomerType.class;

	
	@Override
	public Class getEntityClass() {
		return mClassName;
	}

}
