package com.spring.review;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;
	
	@Override
	public List<ReviewDTO> selectAll(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDTO selectOne(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
