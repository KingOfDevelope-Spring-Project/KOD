package com.spring.order;

import java.util.List;

public interface OrderService {
	List<OrderDTO> selectAll(OrderDTO orderDTO);
	OrderDTO selectOne(OrderDTO orderDTO);
	boolean insert(OrderDTO orderDTO);
	boolean update(OrderDTO orderDTO);
	boolean delete(OrderDTO orderDTO);
}
