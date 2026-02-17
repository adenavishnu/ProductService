package com.plentiva.productservice.mappers;

import com.plentiva.productservice.dtos.CategoryResponse;
import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.models.Product;
import org.springframework.stereotype.Component;
import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.repository.CategoriesRespository;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProductMapper implements IProductMapper {
    @Autowired
    private CategoriesRespository categoriesRespository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toModel(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setThumbnail(productRequest.getThumbnail());
        product.setProductGallery(productRequest.getProductGallery());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        if (productRequest.getCategoryId() != null) {
            Category category = categoriesRespository.findById(productRequest.getCategoryId()).orElse(null);
            product.setCategory(category);
        } else {
            product.setCategory(null);
        }
        return product;
    }

    /// @param product
    /// @return ProductResponse
    @Override
    public ProductResponse toResponse(Product product) {
        CategoryResponse categoryResponse = categoryMapper.toResponse(product.getCategory());
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setThumbnail(product.getThumbnail());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setProductGallery(product.getProductGallery());
        response.setCategory(categoryResponse);
        return response;
    }
}
