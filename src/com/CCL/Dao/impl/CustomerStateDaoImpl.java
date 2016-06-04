package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.CustomerState;

public class CustomerStateDaoImpl extends BaseDao<CustomerState> implements CustomerStateDao {

	private final static Class mClassName = CustomerState.class;


	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
