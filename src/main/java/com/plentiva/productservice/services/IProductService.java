package com.plentiva.productservice.services;

import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.models.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    Product getProductById(UUID id) throws ChangeSetPersister.NotFoundException;

    List<ProductResponse> getAllProducts();

    Product saveProduct(ProductRequest product);

    Product updateProduct(UUID id, ProductRequest product);

    void deleteProduct(UUID id);

    List<ProductResponse> getProductsByCategory(UUID categoryId);

}
