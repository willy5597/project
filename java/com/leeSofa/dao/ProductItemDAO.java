package com.leeSofa.dao;

import java.util.List;
import java.util.Optional;

import com.leeSofa.model.po.ProductItem;

public interface ProductItemDAO {
	Integer addProductItem(ProductItem productItem);
    ProductItem update(ProductItem productItem);
    Integer deleteById(Integer id);
    Optional<ProductItem> findById(Integer id);
    List<ProductItem> findAll();

}
