package com.CCL.Dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.BicycleDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class BicycleDaoImplTest {

	BicycleDao dao = new BicycleDaoImpl();

	@Test
	public void testGet() {
		Bicycle b = dao.get(2);

		System.out.println(b);
	}

	@Test
	public void testQueryAll() {
		List<Bicycle> queryAll = dao.queryAll();

		System.out.println(StringUtils.join(queryAll, "\n"));

	}

	@Test
	public void testRemove() {
		dao.remove(2);

	}

	@Test
	public void testAdd() {
		Bicycle bicycle = new Bicycle();
		
		BicycleStateDaoImpl bicycleDao = new BicycleStateDaoImpl();
		bicycle.setName("abce");
		BicycleState bicycleState = bicycleDao.get(1);
		bicycle.setBicycleState(bicycleState);

		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("bbbbbbbbbbb");
		
		bicycleState = new BicycleState();
		bicycleState.setId(1);
		bicycleState.setName("c");
		bicycle.setBicycleState(bicycleState);
		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("eee");
		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("bbabadfdssce");
		bicycleState = bicycleDao.get(2);
		bicycle.setBicycleState(bicycleState);
		dao.add(bicycle);
		


	}

	@Test
	public void testUpdate() {
		Bicycle bicycle = dao.get(32);
		if(bicycle == null) return;
		bicycle.setName("323443");
		dao.update(bicycle);
		
		
		

	}

	public static void main(String[] args) {
		BicycleDaoImplTest bicycleDaoTest = new BicycleDaoImplTest();
		bicycleDaoTest.testAdd();
		
		bicycleDaoTest.testqueryByExample();
		
	}
	
	@Test
	public void testqueryByExample() {
		Bicycle instance = new Bicycle();
		
		BicycleType bicycleType = new BicycleType();
		
		bicycleType.setId(3);
		bicycleType.setName("ABC");
		instance.setBicycleType(bicycleType);
		instance.setName("abce");
		List<Bicycle> queryAll = dao.queryByExample(instance );
		System.out.println("list:");
		System.out.println(StringUtils.join(queryAll, "\n"));
	}
}
