package com.spring.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.order.DAO.OrderContentDAO_ver2;

@Service("orderContentService")
public class OrderContentServiceImpl implements OrderContentService {

	@Autowired
	private OrderContentDAO_ver2 orderContentDAO;

	@Override
	public List<OrderContentDTO> selectAll(OrderContentDTO orderContentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderContentDTO selectOne(OrderContentDTO orderContentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(OrderContentDTO orderContentDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OrderContentDTO orderContentDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderContentDTO orderContentDTO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
