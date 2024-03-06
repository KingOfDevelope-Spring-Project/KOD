package com.spring.product.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.product.ProductDTO;

@Repository("productDAO")
public class ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<ProductDTO> selectAll(ProductDTO productDTO) {
		return (List<ProductDTO>) jdbcTemplate.query(SELECTALL, new ProductRowMapper());
	}
	
	public ProductDTO selectOne(ProductDTO productDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new ProductRowMapper());
	}
	
	public boolean insert(ProductDTO productDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(ProductDTO productDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(ProductDTO productDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class ProductRowMapper implements RowMapper<ProductDTO>{
	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO data = new ProductDTO();
		return data;
	}
}
