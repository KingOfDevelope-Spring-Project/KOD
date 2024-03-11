package com.spring.order.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.order.OrderContentDTO;

@Repository("orderContentDAO")
public class OrderContentDAO_ver2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 주문 상세 내역 출력
	private static final String SELECTALL = "SELECT OC.ORDERCONTENT_ID ,OC.ORDERLIST_ID, OC.ORDERCONTENT_CNT, OC.PRODUCT_ID, P.PRODUCT_IMG, P.PRODUCT_NAME, P.PRODUCT_CATEGORY, P.PRODUCT_PRICE FROM ORDERCONTENT OC INNER JOIN PRODUCT P ON P.PRODUCT_ID = OC.PRODUCT_ID WHERE OC.ORDERLIST_ID = ?";
	
	// 판매량 top 3
	private static final String SELECTTOP3="SELECT r.PRODUCT_ID , r.PRODUCT_IMG , r.PRODUCT_CATEGORY , r.PRODUCT_NAME , r.PRODUCT_PRICE, r.TOTAL "
			+ "FROM "
			+ "(SELECT p.PRODUCT_ID , p.PRODUCT_IMG , p.PRODUCT_CATEGORY , p.PRODUCT_NAME ,p.PRODUCT_PRICE, SUM(oc.ORDERCONTENT_CNT) AS TOTAL "
			+ "FROM PRODUCT p "
			+ "INNER JOIN ORDERCONTENT oc ON p.PRODUCT_ID = oc.PRODUCT_ID "
			+ "GROUP BY p.PRODUCT_ID ,p.PRODUCT_IMG , p.PRODUCT_CATEGORY , p.PRODUCT_NAME ,p.PRODUCT_PRICE "
			+ "ORDER BY TOTAL DESC) r "
			+ "WHERE ROWNUM <=3";
	private static final String SELECTONE = "";
	
	// 결제 후 해당 주문 번호를 가져와 주문 상세 내역을 저장
	private static final String INSERT = "INSERT INTO ORDERCONTENT "
			+ " (ORDERCONTENT_ID, ORDERLIST_ID, PRODUCT_ID, ORDERCONTENT_CNT) "
			+ " VALUES((SELECT NVL(MAX(ORDERCONTENT_ID),0)+1 FROM ORDERCONTENT), ?, ?, ?)";
	
	private static final String UPDATE = "";
	private static final String DELETE = "";
	
	public List<OrderContentDTO> selectAll(OrderContentDTO orderContentDTO) {
		if(orderContentDTO.getSearchCondition().equals("top3")) {	// 판매량 순위 3위까지 선택
			return (List<OrderContentDTO>) jdbcTemplate.query(SELECTTOP3, new OrderContentTop3RowMapper()); // top3 RowMapper 사용
		}
		else if(orderContentDTO.getSearchCondition().equals("paymentDetail")) {	// 결제 내역
			return (List<OrderContentDTO>) jdbcTemplate.query(SELECTALL, new OrderContentRowMapper());	// 결제내역 RowMapper 사용
		}
		return null;
	}
	
	public OrderContentDTO selectOne(OrderContentDTO orderContentDTO) {
		Object[] args = {};
		return jdbcTemplate.queryForObject(SELECTONE, args, new OrderContentRowMapper());
	}
	
	public boolean insert(OrderContentDTO orderContentDTO) {
		int result = jdbcTemplate.update(INSERT, orderContentDTO.getOdListID(), orderContentDTO.getProductID(), orderContentDTO.getOdContentID());
		if(result <=0 ) {
			return false;
		}
		return true;
	}
	
	public boolean update(OrderContentDTO orderContentDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(OrderContentDTO orderContentDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}

// 결제내역에 사용할 RowMapper
class OrderContentRowMapper implements RowMapper<OrderContentDTO>{
	@Override
	public OrderContentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderContentDTO data = new OrderContentDTO();
		data.setProductID(rs.getInt("PRODUCT_ID"));
		data.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		data.setProductImg(rs.getString("PRODUCT_IMG"));
		data.setProductName(rs.getString("PRODUCT_NAME"));
		data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
		data.setOdContentCnt(rs.getInt("ORDERCONTENT_CNT"));
		data.setOdListID(rs.getInt("ORDERLIST_ID"));
		data.setOdContentID(rs.getInt("ORDERCONTENT_ID"));
		return data;
	}
}

// top3에 사용할 RowMapper
class OrderContentTop3RowMapper implements RowMapper<OrderContentDTO>{
	@Override
	public OrderContentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderContentDTO data = new OrderContentDTO();
		data.setProductID(rs.getInt("PRODUCT_ID"));
		data.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		data.setProductImg(rs.getString("PRODUCT_IMG"));
		data.setProductName(rs.getString("PRODUCT_NAME"));
		data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
		return data;
	}
}
