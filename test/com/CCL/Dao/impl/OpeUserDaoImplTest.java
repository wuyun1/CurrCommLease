package com.CCL.Dao.impl;

import org.junit.Test;

import com.CCL.Dao.OpeUserDao;
import com.CCL.beans.OpeUser;

public class OpeUserDaoImplTest {

	
	OpeUserDao dao = new OpeUserDaoImpl();
	@Test
	public void testDelete() {
		dao.remove(1);
	}
	
	@Test
	public void testCheckOpePer(){
		OpeUser opeUser = dao.queryAll().get(0);
		
		System.out.println(opeUser.getOpePer());
	}

}
