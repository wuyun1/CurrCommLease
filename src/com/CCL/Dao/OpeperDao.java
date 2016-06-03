package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Opeper;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OpeperDao  {

	Opeper get(int id);
	
	List<Opeper> queryAll();
	
	void remove(int id);
	
	void add(Opeper opeper);
	
	void update(Opeper opeper);
	
	
	//通过对象查询
	List<Opeper> queryByExample(Opeper instance);
	
}
