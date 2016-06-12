package com.CCL.Dao.impl;

import org.junit.Test;

import com.CCL.Dao.OpeUserDao;

public class OpeUserDaoImplTest {

	
	OpeUserDao dao = new OpeUserDaoImpl();
	@Test
	public void testDelete() {
		dao.remove(1);
	}

}
