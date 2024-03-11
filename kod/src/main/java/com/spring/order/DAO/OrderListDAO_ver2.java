package com.spring.order.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.order.OrderListDTO;

@Repository("orderDAO")
public class OrderListDAO_ver2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "SELECT ORDERLIST_ID, MEMBER_ID, ORDERLIST_DATE FROM ORDERLIST WHERE MEMBER_ID=? ORDER BY ORDERLIST_ID DESC";
	private static final String SELECTONE = "SELECT NVL(MAX(ORDERLIST_ID),0) AS MAX_ID FROM ORDERLIST WHERE MEMBER_ID=?";
	private static final String INSERT = "INSERT INTO ORDERLIST "
			+ "	(ORDERLIST_ID, MEMBER_ID, ORDERLIST_DATE) "
			+ " VALUES((SELECT NVL(MAX(ORDERLIST_ID),0)+1 FROM ORDERLIST), ?, SYSDATE)";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<OrderListDTO> selectAll(OrderListDTO orderDTO) {
		return (List<OrderListDTO>) jdbcTemplate.query(SELECTALL, new OrderRowMapper());
	}
	
	public OrderListDTO selectOne(OrderListDTO orderDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new OrderRowMapper());
	}
	
	public boolean insert(OrderListDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT, orderDTO.getMemberID());
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(OrderListDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(OrderListDTO orderDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class OrderRowMapper implements RowMapper<OrderListDTO>{
	@Override
	public OrderListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderListDTO data = new OrderListDTO();
		data.setOdListID(rs.getInt("ORDERLIST_ID"));
		data.setOdListDate(rs.getDate("ORDERLIST_DATE"));
		return data;
	}
}
