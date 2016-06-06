package com.CCL.view.kaitaimgr.service;

import java.util.List;

import com.CCL.Dao.BicycleDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.view.kaitaimgr.mydao.MyBicycleDaoImpl;

public class BicycleService {
	
	static BicycleDao bd = new MyBicycleDaoImpl();
	

	public static List<Bicycle> queryByType(BicycleType selectedItem) {
		return bd.queryByType(selectedItem);
	}

}
