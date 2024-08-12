package com.leeSofa.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.leeSofa.model.po.ProductItem;


@Repository
public class ProductItemDAOImpl implements ProductItemDAO {

	@Autowired
	JdbcTemplate jdbcTemplate; // 資料庫

    @Override//新增
    public Integer addProductItem(ProductItem productItem) {
        String sql = "insert into productitem(addingId, productId, productPrice, stock, picture, creatdate) value(?, ?, ?, ?, ?, ?)";
        int rowcount = jdbcTemplate.update(sql, productItem.getAddingId(),
        		                                productItem.getProductId(),
        		                                productItem.getProductPrice(),
        		                                productItem.getStock(),
        		                                productItem.getPicture(),
        		                                productItem.getCreatDate());
        return rowcount;
    }

    @Override
    public Integer deleteById(Integer id) {
		String sql = "delete from Productitem where addingId = ?";
		int rowcount = jdbcTemplate.update(sql, id);
		return rowcount;
  }

    @Override
    public Optional<ProductItem> findById(Integer id) {
    	String sql = "select addingId, productId, productPrice, stock,  picture, creatdate from productitem where addingId = ?";
    	try {
			ProductItem item = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProductItem.class), id);
			return Optional.of(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
       return  Optional.of(null);
    }

    @Override
    public List<ProductItem> findAll() {
        String sql = "select addingId, productId, productPrice, stock, picture, creatdate from productitem";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductItem.class));
    }

	@Override
	public ProductItem update(ProductItem productItem) {
		String sql = "insert into productitem(addingId, productId, productPrice, stock, picture, creatdate) value(?, ?, ?, ?, ?, ?)";
		 jdbcTemplate.update(sql, 
                 productItem.getAddingId(),    
                 productItem.getProductId(), 
                 productItem.getProductPrice(), 
                 productItem.getStock(), 
                 productItem.getPicture(), 
                 productItem.getCreatDate());
        return productItem;
	}
}