package com.plentiva.productservice.mappers;

import com.plentiva.productservice.dtos.CategoryRequest;
import com.plentiva.productservice.dtos.CategoryResponse;
import com.plentiva.productservice.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements ICategoryMapper {

    @Override
    public CategoryResponse toResponse(Category category) {
        CategoryResponse dto = new CategoryResponse();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setSlug(category.getSlug());
        dto.setImageUrl(category.getImageUrl());
        dto.setIsActive(category.getIsActive());
        dto.setDisplayOrder(category.getDisplayOrder());
        dto.setDateCreated(category.getDateCreated());

        if (category.getParent() != null) {
            dto.setParentId(category.getParent().getId());
        }

        return dto;
    }

    @Override
    public  Category toEntity(CategoryRequest request, Category parent) {
        Category category = new Category();

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setSlug(request.getSlug());
        category.setImageUrl(request.getImageUrl());
        category.setIsActive(request.getIsActive());
        category.setDisplayOrder(request.getDisplayOrder());
        category.setParent(parent);

        return category;
    }

}
