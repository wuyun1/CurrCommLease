package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OpeUser;

public class OpeUserDaoImpl extends BaseDao<OpeUser> implements OpeUserDao {

	private final static Class mClassName = OpeUser.class;

	

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
