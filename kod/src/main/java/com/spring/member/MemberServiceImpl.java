package com.spring.member;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
