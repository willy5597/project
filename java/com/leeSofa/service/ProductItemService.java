 package com.leeSofa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeSofa.dao.ProductItemDAO;
import com.leeSofa.model.dto.ProductItemDto;
import com.leeSofa.model.po.ProductItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemDAO productItemDAO;

    public Integer addProductItem(ProductItem productItem) {
        return productItemDAO.addProductItem(productItem);
    }

    public Integer deleteProductItem(Integer id) {
        return productItemDAO.deleteById(id);
    }

    public ProductItem updateProductItem(ProductItem productItem) {
        return productItemDAO.update(productItem);
    }

    public Optional<ProductItem> getProductItemById(Integer id) {
        return productItemDAO.findById(id);
    }

    public List<ProductItem> getAllProductItems() {
        return productItemDAO.findAll();
    }
    
    public List<ProductItemDto> findItems() {
		List<ProductItemDto> productItemDtos = new ArrayList<>();
		List<ProductItem> Items = getAllProductItems();
		//po轉dto
		for(ProductItem productItem : Items) {
			ProductItemDto productItemDto = new ProductItemDto();
			productItemDto.setAddingId(productItem.getAddingId());
			productItemDto.setProductId(productItem.getProductId());
			productItemDto.setStock(productItem.getStock());
			productItemDto.setProductPrice(productItem.getProductPrice());
			productItemDto.setPicture(productItem.getPicture());
			productItemDto.setCreatDate(productItem.getCreatDate());
			productItemDtos.add(productItemDto);
		}
		return productItemDtos;
	}
}