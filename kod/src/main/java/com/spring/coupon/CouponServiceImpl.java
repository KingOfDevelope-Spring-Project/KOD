package com.spring.coupon;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("couponService")
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponDAO couponDAO;
	
	@Override
	public List<CouponDTO> selectAll(CouponDTO couponDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouponDTO selectOne(CouponDTO couponDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(CouponDTO couponDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CouponDTO couponDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CouponDTO couponDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
