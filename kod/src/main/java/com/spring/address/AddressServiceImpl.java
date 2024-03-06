package com.spring.address;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDAO;
	
	@Override
	public List<AddressDTO> selectAll(AddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDTO selectOne(AddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(AddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
