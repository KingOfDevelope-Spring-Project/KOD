package com.spring.wishList.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.wishList.WishListDTO;

@Repository("wishListDAO")
public class WishListDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<WishListDTO> selectAll(WishListDTO wishListDTO) {
		return (List<WishListDTO>) jdbcTemplate.query(SELECTALL, new WishListRowMapper());
	}
	
	public WishListDTO selectOne(WishListDTO wishListDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new WishListRowMapper());
	}
	
	public boolean insert(WishListDTO wishListDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(WishListDTO wishListDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(WishListDTO wishListDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class WishListRowMapper implements RowMapper<WishListDTO>{
	@Override
	public WishListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		WishListDTO data = new WishListDTO();
		return data;
	}
}
