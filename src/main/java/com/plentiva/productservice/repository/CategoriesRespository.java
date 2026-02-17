package com.plentiva.productservice.repository;

import com.plentiva.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriesRespository extends JpaRepository<Category, UUID> {
    boolean existsBySlug(String slug);
}
