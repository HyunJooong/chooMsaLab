package com.choo.msa.chooMsaLab.product.entity;

import com.choo.msa.chooMsaLab.product.dto.ProductRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer stock;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Product(Long categoryId, String name, BigDecimal price, String description, Integer stock) {
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public void updateProduct(ProductRequest request){
        this.categoryId = request.getCategoryId();
        this.name = request.getName();
        this.price = request.getPrice();
        this.description = request.getDescription();
        this.stock = request.getStock();
    }
}