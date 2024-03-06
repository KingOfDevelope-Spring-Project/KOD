package com.spring.order.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.order.OrderDTO;

@Repository("orderDAO")
public class OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<OrderDTO> selectAll(OrderDTO orderDTO) {
		return (List<OrderDTO>) jdbcTemplate.query(SELECTALL, new OrderRowMapper());
	}
	
	public OrderDTO selectOne(OrderDTO orderDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new OrderRowMapper());
	}
	
	public boolean insert(OrderDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(OrderDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(OrderDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class OrderRowMapper implements RowMapper<OrderDTO>{
	@Override
	public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDTO data = new OrderDTO();
		return data;
	}
}
