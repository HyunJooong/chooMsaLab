package com.choo.msa.chooMsaLab.category.dto;

import com.choo.msa.chooMsaLab.category.entity.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {


    private final String name;

    public CategoryResponse(Category category) {

        this.name = category.getName();

    }
}