package com.plentiva.productservice.services;

import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.mappers.IProductMapper;
import com.plentiva.productservice.models.Product;
import com.plentiva.productservice.repository.ProductsRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService {

    private final ProductsRepository productsRepository;
    private final IProductMapper productMapper;

    public ProductService(ProductsRepository productsRepository, IProductMapper productMapper) {
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

    @Override
    public List<ProductResponse> getProductsByCategory(UUID categoryId) {
        return List.of();
    }
}
