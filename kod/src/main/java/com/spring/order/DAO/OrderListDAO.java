package com.spring.order.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.common.JDBCUtil;
import com.spring.order.OrderListDTO;


public class OrderListDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	// 주문 내역 최신순 출력
	private static final String SELECTALL="SELECT ORDERLIST_ID, MEMBER_ID, ORDERLIST_DATE FROM ORDERLIST WHERE MEMBER_ID=? ORDER BY ORDERLIST_ID DESC";
	
	// 주문 상세 내역을 저장하기 위한 주문번호 최댓값 가져오기
	private static final String SELECTONE="SELECT NVL(MAX(ORDERLIST_ID),0) AS MAX_ID FROM ORDERLIST WHERE MEMBER_ID=?";
	
	// 결제 후 주문 내역 저장
	private static final String INSERT="INSERT INTO ORDERLIST "
			+ " (ORDERLIST_ID, MEMBER_ID, ORDERLIST_DATE) "
			+ " VALUES((SELECT NVL(MAX(ORDERLIST_ID),0)+1 FROM ORDERLIST), ?, SYSDATE)";
	private static final String UPDATE="";
	private static final String DELETE="";
	
	public ArrayList<OrderListDTO> selectAll(OrderListDTO oDTO) {
		ArrayList<OrderListDTO> datas = new ArrayList<OrderListDTO>();	
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SELECTALL);
			pstmt.setString(1, oDTO.getMemberID());			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				OrderListDTO data = new OrderListDTO();
				data.setOdListID(rs.getInt("ORDERLIST_ID"));
				data.setOdListDate(rs.getDate("ORDERLIST_DATE"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public OrderListDTO selectOne(OrderListDTO oDTO) {
		OrderListDTO data=null;

		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTONE);
			pstmt.setString(1, oDTO.getMemberID());
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new OrderListDTO();
				data.setOdListID(rs.getInt("MAX_ID"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}

		return data;
	}
	public boolean insert(OrderListDTO oDTO) {
		conn=JDBCUtil.connect();	// JDBC 연결
		try {
			pstmt=conn.prepareStatement(INSERT);	// INSERT 쿼리 사용
			pstmt.setString(1, oDTO.getMemberID());		// 쿼리의 1번째 ?(mId)에 oDTO.getmId값 넣기 
			int result=pstmt.executeUpdate();		// executeUpdate 결과값 result에 저장 / 성공이면 1, 실패면 0
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);	// JDBC 연결해제
		}
		return true;
	}
	public void update() {
		
	}
	public void delete() {
		
	}
}
