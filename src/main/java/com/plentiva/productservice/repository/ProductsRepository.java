package com.plentiva.productservice.repository;

import com.plentiva.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByCategory_Id(UUID categoryId);
}
