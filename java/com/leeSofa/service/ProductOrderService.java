package com.leeSofa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeSofa.dao.ProductOrderDAO;
import com.leeSofa.model.dto.ProductOrderDto;
import com.leeSofa.model.po.ProductOrder;

@Service
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDAO ProductOrderDAO;
	
	public  ProductOrder creatProductOrder(ProductOrder productOrder) {
		return ProductOrderDAO.createOrder(productOrder);
	}
	
	public Integer deleteProductOrder(Integer id) {
		return ProductOrderDAO.deleteById(id);
	}
	
	public Integer updaProductOrder(ProductOrder productOrder) {
		return ProductOrderDAO.updateProductOrder(productOrder);
	}
	
	public Optional<ProductOrder>getOrderById(Integer id){
		return ProductOrderDAO.findById(id);
	}

	public List<ProductOrder>getAllProductOrders(){
		return ProductOrderDAO.findAll();
	}
	
	public List<ProductOrderDto> findOrderDtos(){
		List<ProductOrderDto> productOrderDtos = new ArrayList<>();
		List<ProductOrder> orders = getAllProductOrders();
		//po轉dto
		for(ProductOrder productOrder : orders) {
			ProductOrderDto productOrderDto = new ProductOrderDto();
			productOrderDto.setOrderId(productOrder.getOrderId());
			productOrderDto.setProductId(productOrder.getProductId());
			productOrderDto.setProductPrice(productOrder.getProductPrice());
			productOrderDto.setUserId(productOrder.getUserId());
			productOrderDto.setCreatDate(productOrder.getCreatDate());
			productOrderDtos.add(productOrderDto);
		}
		return productOrderDtos;
	}
}

