package com.choo.msa.chooMsaLab.product.dto;

import com.choo.msa.chooMsaLab.product.entity.Product;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductResponse {

    private final String name;
    private final Integer stock;
    private final BigDecimal price;

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.stock = product.getStock();
        this.price = product.getPrice();
    }
}
