package com.leeSofa.model.dto;





import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDto {
	private Integer orderId;
	private Integer productId;
	private Integer productPrice;
	private Integer userId;
	private Timestamp creatDate;
	
}

