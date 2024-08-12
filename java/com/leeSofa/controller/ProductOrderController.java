package com.leeSofa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.leeSofa.model.dto.ProductOrderDto;
import com.leeSofa.model.dto.UserDto;
import com.leeSofa.model.po.ProductOrder;
import com.leeSofa.service.ProductOrderService;

@Controller
@RequestMapping("/product_order")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@PostMapping
	public ResponseEntity<ProductOrder> creatProductOrder(@RequestBody ProductOrder productorder){
		ProductOrder creatProductOrder = productOrderService.creatProductOrder(productorder);
		return ResponseEntity.ok(creatProductOrder);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteProductOrder(@PathVariable Integer id){
		if (productOrderService.deleteProductOrder(id) != null) {
            return ResponseEntity.ok().build();
        }else {
        return ResponseEntity.notFound().build();
	}
}
	@PutMapping("/{id}")
	public ResponseEntity<Integer> updateProductOrder(@PathVariable Integer id, @RequestBody ProductOrder productorder){
		productorder.setOrderId(id);
		Integer updateProductOrder = productOrderService.updaProductOrder(productorder);
		return ResponseEntity.ok(updateProductOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductOrder> getProductOrderById(@PathVariable Integer id){
		return productOrderService.getOrderById(id)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public String findOrderDtos(Model model) {
        List<ProductOrderDto> productOrderDtos = productOrderService.findOrderDtos();
        model.addAttribute("productOrderDtos",productOrderDtos);
        return "order/orderlist";
    }

}
