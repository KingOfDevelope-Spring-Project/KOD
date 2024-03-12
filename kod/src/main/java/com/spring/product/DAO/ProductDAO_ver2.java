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
	
	private static final String SELECTALL = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_PRICE, PRODUCT_INFO, PRODUCT_CATEGORY, PRODUCT_STOCK, PRODUCT_IMG "
			+ " FROM PRODUCT";
	private static final String SELECTALL_CATEGORY = "SELECT PRODUCT_CATEGORY, COUNT(PRODUCT_CATEGORY) AS COUNT"
			+ " FROM PRODUCT GROUP BY PRODUCT_CATEGORY";
	// 필터검색용 쿼리
	private static final String SELECTALL_FILTER = 
			" SELECT p.PRODUCT_ID, PRODUCT_NAME, PRODUCT_BRAND, "
			+ " PRODUCT_PRICE, PRODUCT_INFO, PRODUCT_CATEGORY, "
			+ " PRODUCT_STOCK, PRODUCT_IMG, NVL(w.WISHLIST_ID,0) AS ISWISHED "
			+ " FROM PRODUCT p LEFT OUTER JOIN WISHLIST w ON p.PRODUCT_ID = w.PRODUCT_ID AND MEMBER_ID = ";
	private static final String SELECTONE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_PRICE, PRODUCT_INFO, PRODUCT_CATEGORY, PRODUCT_STOCK, PRODUCT_IMG "
			+ "FROM PRODUCT WHERE PRODUCT_ID=?";
	private static final String SELECTONE_CHOICE = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_PRICE, PRODUCT_INFO, PRODUCT_CATEGORY, PRODUCT_STOCK, PRODUCT_IMG "
			+ " FROM PRODUCT ";
	private static final String INSERT_CRAWLING = // [담당 : 정현진]
			  "INSERT "
			+ "INTO PRODUCT( "
			+ "  PRODUCT_ID, "
			+ "  PRODUCT_NAME, "
			+ "  PRODUCT_BRAND, "
			+ "  PRODUCT_PRICE, "
			+ "  PRODUCT_INFO, "
			+ "  PRODUCT_CATEGORY,  "
			+ "  PRODUCT_STOCK,  "
			+ "  PRODUCT_IMG) "
			+ "VALUES(" // 이름 가격 정보 카테고리 수량 이미지
			+ "  (SELECT NVL(MAX(PRODUCT_ID),1000)+1 FROM PRODUCT), "
			+ "?,'Bang&Olufsen',?,?,?,5,?)"; // 상품 크롤링
			
	private static final String UPDATE = "UPDATE PRODUCT SET PRODUCT_STOCK = PRODUCT_STOCK - ? WHERE PRODUCT_ID = ?";
	private static final String DELETE = "";
	
	public List<ProductDTO> selectAll(ProductDTO productDTO) {
		if(search.equals("searchAll")) {
			return (List<ProductDTO>) jdbcTemplate.query(SELECTALL, new ProductRowMapper1());
		}else if(search.equals("filter")) {
			String result = "";
			if(pDTO.getMemberID()!=null) {
				result += " '"+pDTO.getMemberID()+ "' ";
			}else {
				result += " 'NULL' ";
			}
			result += " WHERE ( PRODUCT_PRICE BETWEEN " + pDTO.getMin() + " AND " + pDTO.getMax() + " ) ";
			if(!pDTO.getCategoryList()[0].equals("")) {
				result += "AND ( PRODUCT_CATEGORY = " + " '"+ pDTO.getCategoryList()[0] + "' ";
				for (int i = 1; i < pDTO.getCategoryList().length; i++) {
					result += " OR PRODUCT_CATEGORY = " + " '" + pDTO.getCategoryList()[i] + "' " ;
				}
				result += " ) ";
			}
			result += " ORDER BY p.PRODUCT_ID ";
			result = SELECTALL_FILTER+result;
			return (List<ProductDTO>) jdbcTemplate.query(result, new ProductRowMapper2());
		}else if(search.equals("category")){
			return (List<ProductDTO>) jdbcTemplate.query(SELECTALL_CATEGORY, new ProductRowMapper3());
		}
	}
	
	public ProductDTO selectOne(ProductDTO productDTO) {
		Object[] args = {productDTO.getProductID()};
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
		int result = jdbcTemplate.update(UPDATE);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(ProductDTO productDTO) {
		int result = jdbcTemplate.update(DELETE);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

class ProductRowMapper1 implements RowMapper<ProductDTO>{
	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO data = new ProductDTO();
		data.setProductID(rs.getInt("PRODUCT_ID"));
		data.setProductName(rs.getString("PRODUCT_NAME"));
		data.setProductBrand(rs.getString("PRODUCT_BRAND"));
		data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
		data.setProductStock(rs.getInt("PRODUCT_STOCK"));
		data.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		data.setProductInfo(rs.getString("PRODUCT_INFO"));
		data.setProductImg(rs.getString("PRODUCT_IMG"));
		return data;
	}
}
class ProductRowMapper2 implements RowMapper<ProductDTO>{
	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO data = new ProductDTO();
		data.setProductID(rs.getInt("PRODUCT_ID"));
		data.setProductName(rs.getString("PRODUCT_NAME"));
		data.setProductBrand(rs.getString("PRODUCT_BRAND"));
		data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
		data.setProductStock(rs.getInt("PRODUCT_STOCK"));
		data.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		data.setProductInfo(rs.getString("PRODUCT_INFO"));
		data.setProductImg(rs.getString("PRODUCT_IMG"));
		data.setIsWished(rs.getInt("ISWISHED"));
		return data;
	}
}
class ProductRowMapper3 implements RowMapper<ProductDTO>{
	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO data = new ProductDTO();
		data.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		data.setProductCnt(rs.getInt("COUNT"));
		return data;
	}
}


