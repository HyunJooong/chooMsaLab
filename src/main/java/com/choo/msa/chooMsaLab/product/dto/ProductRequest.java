package com.choo.msa.chooMsaLab.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequest {

    //상품Id
    private Long id;
    //상품명
    @NotBlank
    private String name;
    //상품가격
    private BigDecimal price;
    //상품 설명
    private String description;
    //상품 카테고리
    private Long categoryId;
    //상품재고
    private Integer stock;
}
