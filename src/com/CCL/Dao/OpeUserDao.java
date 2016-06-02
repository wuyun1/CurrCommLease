package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OpeUser;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OpeUserDao {

	OpeUser get(int id);

	List<OpeUser> queryAll();

	void remove(int id);

	void add(OpeUser opeUser);

	void update(OpeUser opeUser);

}
