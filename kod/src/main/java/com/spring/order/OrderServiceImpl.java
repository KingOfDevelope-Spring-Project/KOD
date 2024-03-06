package com.spring.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.order.DAO.OrderDAO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	public OrderDAO orderDAO;
	
	@Override
	public List<OrderDTO> selectAll(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO selectOne(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
