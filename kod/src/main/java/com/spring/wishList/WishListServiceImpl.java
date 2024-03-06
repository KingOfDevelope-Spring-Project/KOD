package com.spring.wishList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wishList.DAO.WishListDAO;

@Service("wishListService")
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private WishListDAO wishListDAO;
	
	@Override
	public List<WishListDTO> selectAll(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WishListDTO selectOne(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(WishListDTO wishListDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
