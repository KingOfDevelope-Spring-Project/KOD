package com.spring.cart;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public List<CartDTO> selectAll(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO selectOne(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
