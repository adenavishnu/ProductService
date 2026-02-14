package com.ecommerce.productsservice.services;

import com.ecommerce.productsservice.dtos.ProductRequest;
import com.ecommerce.productsservice.dtos.ProductResponse;
import com.ecommerce.productsservice.mappers.IProductMapper;
import com.ecommerce.productsservice.models.Product;
import com.ecommerce.productsservice.repository.ProductsRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductsService implements IProductService {

    private final ProductsRepository productsRepository;
    private final IProductMapper productMapper;

    public ProductsService(ProductsRepository productsRepository, IProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product getProductById(UUID id) throws ChangeSetPersister.NotFoundException {
        return productsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productsRepository.findAll();

        return products.stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public Product saveProduct(ProductRequest product) {
        return null;
    }

    @Override
    public Product updateProduct(UUID id, ProductRequest product) {
        return null;
    }

    @Override
    public void deleteProduct(UUID id) {

    }
}
