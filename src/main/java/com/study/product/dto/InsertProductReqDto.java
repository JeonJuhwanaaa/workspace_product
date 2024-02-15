package com.study.product.dto;

import com.study.product.vo.ProductVo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
// 데이터를 변환함
public class InsertProductReqDto {
	
	private String productName;
	private int productPrice;
	private String productSize;
	
	public ProductVo toVo() {
		return ProductVo.builder()
				.productName(productName)
				.productPrice(productPrice)
				.productSize(productSize)
				.build();
	}
}
