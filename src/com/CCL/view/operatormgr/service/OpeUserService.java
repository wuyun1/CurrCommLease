package com.CCL.view.operatormgr.service;

import com.CCL.beans.OpeUser;

public class OpeUserService {

	public static boolean update(OpeUser updateOpeUser) {
		
		if(updateOpeUser ==null) return false;
		System.out.println("�Ա����û�"+updateOpeUser.getName()+"����");
		
		return true;
	}

}
