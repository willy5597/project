package com.leeSofa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.leeSofa.model.dto.ProductItemDto;
import com.leeSofa.model.po.ProductItem;
import com.leeSofa.service.ProductItemService;

import java.util.List;

@Controller
@RequestMapping("/product_items")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @PostMapping
    public ResponseEntity<Integer> addProductItem(@RequestBody ProductItem productItem) {
        Integer createdProductItem = productItemService.addProductItem(productItem);
        return ResponseEntity.ok(createdProductItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductItem(@PathVariable Integer id) {
    	if (productItemService.deleteProductItem(id) != null) {
            return ResponseEntity.ok().build();
        }else {
        return ResponseEntity.notFound().build();
    }
   }

    @PutMapping("/{id}")
    public ResponseEntity<ProductItem> updateProductItem(@PathVariable Integer id, @RequestBody ProductItem productItem) {
        productItem.setAddingId(id);
        ProductItem updatedProductItem = productItemService.updateProductItem(productItem);
        return ResponseEntity.ok(updatedProductItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductItem> getProductItemById(@PathVariable Integer id) {
        return productItemService.getProductItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public String findItems(Model model) {
        List<ProductItemDto> productItemDtos = productItemService.findItems();
        model.addAttribute("productItemDtos",productItemDtos);
        return "productitem/itemlist";
    }
}