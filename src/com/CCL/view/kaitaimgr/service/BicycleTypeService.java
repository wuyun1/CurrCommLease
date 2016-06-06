package com.CCL.view.kaitaimgr.service;

import java.util.List;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.impl.BicycleTypeDaoImpl;
import com.CCL.beans.BicycleType;
import com.CCL.view.kaitaimgr.mydao.MyBicycleTypeDaoImpl;

public class BicycleTypeService {
	
	public static BicycleTypeDao btd = new MyBicycleTypeDaoImpl();

	public static List<BicycleType> getAllType() {
		
		return btd.queryAll();
	}

	
}
