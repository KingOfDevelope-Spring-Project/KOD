package com.spring.member.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.member.MemberDTO;

@Repository("memberDAO")
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		return (List<MemberDTO>) jdbcTemplate.query(SELECTALL, new MemberRowMapper());
	}
	
	public MemberDTO selectOne(MemberDTO memberDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new MemberRowMapper());
	}
	
	public boolean insert(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class MemberRowMapper implements RowMapper<MemberDTO>{
	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO data = new MemberDTO();
		return data;
	}
}
