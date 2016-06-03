package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Customer;
import com.CCL.beans.OpeUser;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OpeUserDao {

	OpeUser get(int id);

	List<OpeUser> queryAll();
	//ͨ�������ѯ
		List<OpeUser> queryByExample(OpeUser instance);

	void remove(int id);

	void add(OpeUser opeUser);

	void update(OpeUser opeUser);

}
