package com.plentiva.productservice.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.mappers.IProductMapper;
import com.plentiva.productservice.models.Product;
import com.plentiva.productservice.repository.ProductsRepository;
import com.plentiva.productservice.repository.CategoriesRespository;
import com.plentiva.productservice.models.Category;
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
    private final CategoriesRespository categoriesRespository;

    public ProductService(ProductsRepository productsRepository, IProductMapper productMapper, CategoriesRespository categoriesRespository) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
        this.categoriesRespository = categoriesRespository;
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public ProductResponse getProductById(UUID id) throws ChangeSetPersister.NotFoundException {
        Product response = productsRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        response.getProductGallery().size();
        return productMapper.toResponse(response);
    }

    @Override
    @Cacheable(value = "products", key = "'all'")
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        products.forEach(p -> p.getProductGallery().size());
        return products.stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = productsRepository.save(productMapper.toModel(productRequest));
        return productMapper.toResponse(product);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public ProductResponse updateProduct(UUID id, ProductRequest productRequest) {
        Product existing = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setProductName(productRequest.getProductName());
        existing.setDescription(productRequest.getDescription());
        existing.setPrice(productRequest.getPrice());
        existing.setQuantity(productRequest.getQuantity());
        existing.setThumbnail(productRequest.getThumbnail());

        existing.setProductGallery(productRequest.getProductGallery());
        if (productRequest.getCategoryId() != null) {
            Category category = categoriesRespository.findById(productRequest.getCategoryId()).orElse(null);
            existing.setCategory(category);
        } else {
            existing.setCategory(null);
        }

        return productMapper.toResponse(productsRepository.save(existing));
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void deleteProduct(UUID id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productsRepository.delete(product);
    }

    @Override
        public List<ProductResponse> getProductsByCategory(UUID categoryId) {
        List<Product> products = productsRepository.findAllByCategory_Id((categoryId));
        return products.stream()
            .map(productMapper::toResponse)
            .toList();
        }
    
}
