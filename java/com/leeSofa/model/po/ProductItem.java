package com.leeSofa.model.po;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
	private Integer addingId;
	private Integer productId;
	private Integer productPrice;
	private Integer stock;
	private String picture;
	private Timestamp creatDate;

}
