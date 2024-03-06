package com.spring.review.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.review.ReviewDTO;

@Repository("reviewDAO")
public class ReviewDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<ReviewDTO> selectAll(ReviewDTO reviewDTO) {
		return (List<ReviewDTO>) jdbcTemplate.query(SELECTALL, new ReviewRowMapper());
	}
	
	public ReviewDTO selectOne(ReviewDTO reviewDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new ReviewRowMapper());
	}
	
	public boolean insert(ReviewDTO reviewDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(ReviewDTO reviewDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(ReviewDTO reviewDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class ReviewRowMapper implements RowMapper<ReviewDTO>{
	@Override
	public ReviewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewDTO data = new ReviewDTO();
		return data;
	}
}
