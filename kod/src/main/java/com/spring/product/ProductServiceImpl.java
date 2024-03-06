package com.spring.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<ProductDTO> selectAll(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectOne(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return false;
	}
}
