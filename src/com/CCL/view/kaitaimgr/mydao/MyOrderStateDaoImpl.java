package com.CCL.view.kaitaimgr.mydao;

import java.util.List;
import java.util.Map;

import com.CCL.Dao.OrderStateDao;
import com.CCL.beans.OrderState;

public class MyOrderStateDaoImpl implements OrderStateDao {

	@Override
	public OrderState get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderState> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(OrderState bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OrderState bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderState> queryByExample(OrderState instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderState> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderState> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderState> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderState> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
