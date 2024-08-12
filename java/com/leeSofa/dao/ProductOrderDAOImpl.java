package com.leeSofa.dao;




import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;



import com.leeSofa.model.po.ProductOrder;

@Repository
public class ProductOrderDAOImpl implements ProductOrderDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate; // 資料庫

	@Override
	public ProductOrder createOrder(ProductOrder ProductOrder) {
		String sql = "select orderid, productid, productprice, userid, creatdate from productorder";
		jdbcTemplate.update(sql, 
				ProductOrder.getOrderId(),
                ProductOrder.getProductId(), 
                ProductOrder.getProductPrice(), 
                ProductOrder.getUserId(), 
                ProductOrder.getCreatDate());

         return ProductOrder;
	}


	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from ProductOrder where addingid = ?";
		int rowcount = jdbcTemplate.update(sql, id);
		return rowcount;
		}

	@Override
	public  Integer updateProductOrder(ProductOrder Order) {
		String sql = "insert into ProductOrder(orderid, productid, productprice, userid, creatdate) value(?, ?, ?, ?, ?)";
		int rowCount = jdbcTemplate.update(sql, 
				 Order.getProductId(), 
				 Order.getProductPrice(), 
				 Order.getUserId(), 
				 Order.getCreatDate());

         return rowCount;
	}

	@Override
	public Optional<ProductOrder> findById(Integer id) {
		String sql = "select orderid, productid, productprice, userid, creatdate from productorder where addingid = ?";
		try {
			ProductOrder order = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<> (ProductOrder.class), id);
			return Optional.of(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Optional.of(null);
	}

	@Override
	public List<ProductOrder> findAll() {
		String sql = "select orderid, productid, productprice, userid, creatdate from productorder";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductOrder.class));
	}

	/*@Override
	public List<ProductOrder> findAll() {
		String sql = "select addingId, productId, productPrice, userId, addingDate, creaDate from productorder";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductOrder.class));
	}
	
	RowMapper<ProductItemDto> mapper = new RowMapper<>() {
		@Override
		public ProductItemDto mapRow(ResultSet rs, int rowNum)throws SQLException {
			Integer addingId = rs.getInt("addingId");
			Integer productId = rs.getInt("productId");
			Integer productPrice = rs.getInt("productPrice");
			Integer userId = rs.getInt("userId");
			String addingDate = rs.getString("addingDate");
			Timestamp createDate = rs.getTimestamp("creatDate");
			
			
			return null;*/
		
	
	};


