package com.plentiva.productservice.services;

import com.plentiva.productservice.dtos.CategoryRequest;
import com.plentiva.productservice.dtos.CategoryResponse;
import com.plentiva.productservice.mappers.ICategoryMapper;
import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.repository.CategoriesRespository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    private final CategoriesRespository categoriesRespository;
    private final ICategoryMapper categoryMapper;

    public CategoryService(CategoriesRespository categoriesRespository,
                           ICategoryMapper categoryMapper) {
        this.categoriesRespository = categoriesRespository;
        this.categoryMapper = categoryMapper;
    }

    // CREATE
    @Override
    public CategoryResponse save(CategoryRequest request) throws Exception {

        if (categoriesRespository.existsBySlug(request.getSlug())) {
            throw new RuntimeException("Slug already exists");
        }

        Category parent = null;

        if (request.getParentId() != null) {
            parent = categoriesRespository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
        }

        Category category = categoryMapper.toEntity(request, parent);
        Category saved = categoriesRespository.save(category);

        // Clear cache (important)
        evictAllCategoriesCache();

        return categoryMapper.toResponse(saved);
    }

    // UPDATE
    @Override
    @CacheEvict(value = "categories", key = "#id")
    public CategoryResponse update(String id, CategoryRequest request) throws Exception {

        UUID uuid = UUID.fromString(id);

        Category category = categoriesRespository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setSlug(request.getSlug());
        category.setImageUrl(request.getImageUrl());
        category.setIsActive(request.getIsActive());
        category.setDisplayOrder(request.getDisplayOrder());

        if (request.getParentId() != null) {
            Category parent = categoriesRespository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
        } else {
            category.setParent(null);
        }

        Category updated = categoriesRespository.save(category);

        return categoryMapper.toResponse(updated);
    }

    // DELETE
    @Override
    @CacheEvict(value = "categories", key = "#id")
    public void delete(String id) throws Exception {

        UUID uuid = UUID.fromString(id);

        Category category = categoriesRespository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (category.getChildren() != null && !category.getChildren().isEmpty()) {
            throw new RuntimeException("Cannot delete category with sub-categories");
        }

        categoriesRespository.delete(category);
    }

    // FIND BY ID
    @Override
    @Cacheable(value = "categories", key = "#id")
    public CategoryResponse findById(String id) throws Exception {

        System.out.println("Fetching from DB...");

        UUID uuid = UUID.fromString(id);

        Category category = categoriesRespository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return categoryMapper.toResponse(category);
    }

    // FIND ALL
    @Override
    @Cacheable(value = "categories", key = "'all'")
    public List<CategoryResponse> findAll() throws Exception {

        System.out.println("Fetching ALL from DB...");

        List<Category> categories = categoriesRespository.findAll();

        return categories.stream()
                .map(categoryMapper::toResponse)
                .sorted((a, b) -> Integer.compare(a.getDisplayOrder(), b.getDisplayOrder()))
                .toList();
    }

    // Evict all cache manually
    @CacheEvict(value = "categories", allEntries = true)
    public void evictAllCategoriesCache() {
        // method body can be empty
    }
}
