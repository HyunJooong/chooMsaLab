package com.choo.msa.chooMsaLab.category.service;

import com.choo.msa.chooMsaLab.category.dto.CategoryRequest;
import com.choo.msa.chooMsaLab.category.dto.CategoryResponse;
import com.choo.msa.chooMsaLab.category.entity.Category;
import com.choo.msa.chooMsaLab.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 생성
     * @param request
     * @return
     */
    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return new CategoryResponse(categoryRepository.save(category));
    }

    /**
     * 카테고리 수정
     * @param categoryId
     * @return
     */
    @Transactional
    public CategoryResponse updateCategory(Long categoryId) {

        //카테고리 validate
        Category category = validateCategoryExists(categoryId);

        //Dirty checking update
        category.update(category.getName(), category.getDescription());

        return new CategoryResponse(category);

    }

    /**
     * 카테고리 Validate
     * @param categoryId
     */
    public Category validateCategoryExists(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다. id=" + categoryId));
    }
}