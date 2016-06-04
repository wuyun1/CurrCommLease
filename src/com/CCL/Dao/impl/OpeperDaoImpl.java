package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Opeper;

public class OpeperDaoImpl extends BaseDao<Opeper> implements OpeperDao {

	private final static Class mClassName = Opeper.class;

	
	@Override
	public Class getEntityClass() {
		return mClassName;
	}

}
