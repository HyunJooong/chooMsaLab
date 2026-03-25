package com.choo.msa.chooMsaLab.product.service;

import com.choo.msa.chooMsaLab.category.entity.Category;
import com.choo.msa.chooMsaLab.category.service.CategoryService;
import com.choo.msa.chooMsaLab.product.dto.ProductRequest;
import com.choo.msa.chooMsaLab.product.dto.ProductResponse;
import com.choo.msa.chooMsaLab.product.entity.Product;
import com.choo.msa.chooMsaLab.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    /**
     * 상품 등록
     * @param request
     * @return
     */
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {

        categoryService.validateCategoryExists(request.getCategoryId());

        Product product = Product.builder()
                .categoryId(request.getCategoryId())
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .stock(request.getStock())
                .build();

        return new ProductResponse(productRepository.save(product));
    }

    /**
     * 상품 수정
     * @param request
     * @return
     */
    public ProductResponse updateProduct(ProductRequest request) {

        // category validate
        categoryService.validateCategoryExists(request.getCategoryId());

        //product validate
        Product product = validateProductExists(request.getId());

        //상품 수정 dirty checking
        product.updateProduct(request);

        return new ProductResponse(product);
    }


    /**
     * 상품 validate
     * @param productId
     * @return
     */
    public Product validateProductExists(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다. id=" + productId));
    }
}
