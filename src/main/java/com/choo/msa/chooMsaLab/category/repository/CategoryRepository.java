package com.choo.msa.chooMsaLab.category.repository;

import com.choo.msa.chooMsaLab.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}