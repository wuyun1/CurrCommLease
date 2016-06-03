package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OpeUser;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OpeUserDao {

	OpeUser get(int id);

	List<OpeUser> queryAll();
	//通过对象查询
		List<OpeUser> queryByExample(OpeUser instance);

	void remove(int id);

	void add(OpeUser opeUser);

	void update(OpeUser opeUser);

}
