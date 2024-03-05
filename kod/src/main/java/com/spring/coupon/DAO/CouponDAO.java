package com.spring.coupon.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.coupon.CouponDTO;

@Repository("couponDAO")
public class CouponDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<CouponDTO> selectAll(CouponDTO couponDTO) {
		return (List<CouponDTO>) jdbcTemplate.query(SELECTALL, new AddressRowMapper());
	}
	
	public CouponDTO selectOne(CouponDTO couponDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new AddressRowMapper());
	}
	
	public boolean insert(CouponDTO couponDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(CouponDTO couponDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(CouponDTO couponDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class AddressRowMapper implements RowMapper<CouponDTO>{
	@Override
	public CouponDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CouponDTO data = new CouponDTO();
		return data;
	}
}
