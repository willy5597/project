package com.leeSofa.dao;

import java.util.List;
import java.util.Optional;

import com.leeSofa.model.po.ProductOrder;

public interface ProductOrderDAO {
	ProductOrder createOrder(ProductOrder ProductOrder);
	Integer deleteById(Integer id);
    Integer updateProductOrder(ProductOrder productOrder);
	Optional<ProductOrder> findById(Integer id);
	List<ProductOrder> findAll();
}
