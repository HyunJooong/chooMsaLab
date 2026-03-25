package com.choo.msa.chooMsaLab.category.controller;

import com.choo.msa.chooMsaLab.category.dto.CategoryRequest;
import com.choo.msa.chooMsaLab.category.dto.CategoryResponse;
import com.choo.msa.chooMsaLab.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     *카테고리 생성
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(request));
    }

    /**
     * 카테고리 수정
     * @param categoryId
     * @return
     */
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.updateCategory(categoryId));
    }


}