package com.plentiva.productservice.mappers;

import com.plentiva.productservice.dtos.CategoryRequest;
import com.plentiva.productservice.dtos.CategoryResponse;
import com.plentiva.productservice.models.Category;

public interface ICategoryMapper {
    public CategoryResponse toResponse(Category category);
    public Category toEntity(CategoryRequest request, Category parent);
}
