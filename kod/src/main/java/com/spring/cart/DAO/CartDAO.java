package com.spring.cart.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.cart.CartDTO;

@Repository("cartDAO")
public class CartDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<CartDTO> selectAll(CartDTO cartDTO) {
		return (List<CartDTO>) jdbcTemplate.query(SELECTALL, new CartRowMapper());
	}
	
	public CartDTO selectOne(CartDTO cartDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new CartRowMapper());
	}
	
	public boolean insert(CartDTO cartDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(CartDTO cartDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(CartDTO cartDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class CartRowMapper implements RowMapper<CartDTO>{
	@Override
	public CartDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartDTO data = new CartDTO();
		return data;
	}
}
