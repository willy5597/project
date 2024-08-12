package com.leeSofa.model.po;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {
	private Integer orderId;
	private Integer productId;
	private Integer productPrice;
	private Integer userId;
	private Timestamp creatDate;
	
}
