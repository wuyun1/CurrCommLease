package com.CCL.Dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.BicycleDao;
import com.CCL.beans.Bicycle;

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
		bicycle.setName("abce");

		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("abssce");
		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("eee");
		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("bbabadfdssce");
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
		instance.setName("eee");
		List<Bicycle> queryAll = dao.queryByExample(instance );
		System.out.println("list:");
		System.out.println(StringUtils.join(queryAll, "\n"));
	}
}
