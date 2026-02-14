package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.dtos.ProductRequest;
import com.ecommerce.productsservice.dtos.ProductResponse;
import com.ecommerce.productsservice.models.Product;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    Product getProductById(UUID id) throws ChangeSetPersister.NotFoundException;

    List<ProductResponse> getAllProducts();

    Product saveProduct(ProductRequest product);

    Product updateProduct(UUID id, ProductRequest product);

    void deleteProduct(UUID id);
}
