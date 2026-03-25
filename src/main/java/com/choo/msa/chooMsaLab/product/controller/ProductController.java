package com.choo.msa.chooMsaLab.product.controller;

import com.choo.msa.chooMsaLab.product.dto.ProductRequest;
import com.choo.msa.chooMsaLab.product.dto.ProductResponse;
import com.choo.msa.chooMsaLab.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 생성
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.updateProduct(request));
    }
}
