package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Opeper;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OpeperDao  {

	Opeper get(int id);
	
	List<Opeper> queryAll();
	
	void remove(int id);
	
	void add(Opeper opeper);
	
	void update(Opeper opeper);
	
	
	//ͨ�������ѯ
	List<Opeper> queryByExample(Opeper instance);
	
}
