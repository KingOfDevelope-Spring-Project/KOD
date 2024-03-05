package com.spring.address.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.address.AddressDTO;

@Repository("addressDAO")
public class AddressDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<AddressDTO> selectAll(AddressDTO addressDTO) {
		return (List<AddressDTO>) jdbcTemplate.query(SELECTALL, new AddressRowMapper());
	}
	
	public AddressDTO selectOne(AddressDTO addressDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new AddressRowMapper());
	}
	
	public boolean insert(AddressDTO addressDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(AddressDTO addressDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(AddressDTO addressDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class AddressRowMapper implements RowMapper<AddressDTO>{
	@Override
	public AddressDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AddressDTO data = new AddressDTO();
		return data;
	}
}
