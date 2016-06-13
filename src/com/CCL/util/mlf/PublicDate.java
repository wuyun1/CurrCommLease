package com.CCL.util.mlf;

import com.CCL.beans.OpeUser;

public class PublicDate {
	private static OpeUser ouser=null;

	public static OpeUser getOuser() {
		return ouser;
	}

	public static void setOuser(OpeUser ouser) {
		PublicDate.ouser = ouser;
	}

	public  PublicDate(OpeUser ouser) {
      this.ouser=ouser;
	}
	
}
