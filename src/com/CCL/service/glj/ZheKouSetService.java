package com.CCL.service.glj;

import java.util.List;
import java.util.Vector;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.impl.BicycleTypeDaoImpl;
import com.CCL.Dao.impl.CustomerTypeDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.CustomerType;

public class ZheKouSetService {
	BicycleTypeDao bicycleTypeDao = new BicycleTypeDaoImpl();
	CustomerTypeDao customerTypeDao = new CustomerTypeDaoImpl();

	// ����BicycleType��
	public boolean update(BicycleType bicycleType) {
		return bicycleTypeDao.update(bicycleType);
	}

	// ����CustomerType��
	public boolean update(CustomerType customerType) {
		return customerTypeDao.update(customerType);
	}

	public List<BicycleType> getAllBicycleType()
	{
		
		return bicycleTypeDao.queryAll();
	}
	
	public List<CustomerType> getAllCustomerType()
	{
		return customerTypeDao.queryAll();
	}
	
	public Vector<Vector<Object>> getZheKouSetDate() {

		List<BicycleType> bicycle_typelist = bicycleTypeDao.queryAll();
		List<CustomerType> customer_typelist = customerTypeDao.queryAll();

		Vector<Vector<Object>> zhekou_list = new Vector<Vector<Object>>();
		Vector<Object> zhekou_row = null;
		int c = customer_typelist.size();
		int b = bicycle_typelist.size();

		Vector<BicycleType> bicycleType_temp = new Vector<BicycleType>();
		// �Ȼ��浽��ʱ��
		for (BicycleType bic : bicycle_typelist) {
			if (bic.getIsShow()) {
				bicycleType_temp.add(bic);
			}
		}
		Vector<CustomerType> customerType_temp = new Vector<CustomerType>();
		for (CustomerType cus : customer_typelist) // �Ȼ��浽��ʱ��
		{
			if (cus.getIsShow()) {
				customerType_temp.add(cus);
			}

		}
		b = bicycleType_temp.size();
		c = customerType_temp.size();

		if (c > b) {
			for (int i = 0; i < (c - b); i++) {
				BicycleType bicycleType = new BicycleType();
				bicycleType.setName("");
				bicycleType.setId(0);
				bicycleType.setIsShow(true);
				bicycleType_temp.add(bicycleType);
			}
		}
		if (b > c) {
			for (int i = 0; i < (b - c); i++) {
				CustomerType customerType = new CustomerType();
				customerType.setName("");
				customerType.setId(0);
				customerType.setIsShow(true);
				customerType_temp.add(new CustomerType());
			}
		}
		int size = (c > b) ? c : b;
		for (int i = 0; i < size; i++) {
			zhekou_row = new Vector<Object>();
			if (size == c)// customer_typelist������������bicycle_typelist��������
			{
				if (bicycleType_temp.get(i).getName().trim() != null) {
					if (bicycleType_temp.get(i) instanceof BicycleType) {
						zhekou_row.add(i + 1);
						zhekou_row.add(bicycleType_temp.get(i));
						zhekou_row.add(bicycleType_temp.get(i).getDiscount());
					}
				}
				if (customerType_temp.get(i).getName().trim() != null) {
					if (customerType_temp.get(i) instanceof CustomerType) {
						zhekou_row.add(customerType_temp.get(i));
						zhekou_row.add(customerType_temp.get(i).getDiscount());
					}
				}
			} 
			else // customer_typelist������������bicycle_typelist��������
			{
//				if (size == b)// customer_typelist��������С��bicycle_typelist��������
//				{
					if (bicycleType_temp.get(i).getName().trim() != null) {
						if (bicycleType_temp.get(i) instanceof BicycleType) {
							zhekou_row.add(i + 1);
							zhekou_row.add(bicycleType_temp.get(i));
							zhekou_row.add(bicycleType_temp.get(i)
									.getDiscount());
						}
					}
					if (bicycleType_temp.get(i).getName().trim() != null) {
						if (customerType_temp.get(i) instanceof CustomerType) {
							zhekou_row.add(customerType_temp.get(i));
							zhekou_row.add(customerType_temp.get(i)
									.getDiscount());
						}
					}
				}
//			}
			zhekou_list.add(zhekou_row);
		}

		return zhekou_list;
	}
}
