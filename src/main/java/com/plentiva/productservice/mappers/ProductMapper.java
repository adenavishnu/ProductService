package com.plentiva.productservice.mappers;

import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements IProductMapper {
    /// @param productResquest
    /// @return Product
    @Override
    public Product toModel(ProductRequest productResquest) {
        Product product = new Product();
        product.setId(productResquest.getId());
        product.setProductName(productResquest.getProductName());
        product.setPrice(productResquest.getPrice());
        product.setThumbnail(productResquest.getThumbnail());
        product.setProductGallery(productResquest.getProductGallery());
        product.setDescription(productResquest.getDescription());
        product.setCategory(productResquest.getCategory());
        product.setQuantity(productResquest.getQuantity());
        return product;
    }

    /// @param product
    /// @return ProductResponse
    @Override
    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setThumbnail(product.getThumbnail());
        response.setDescription(product.getDescription());
        response.setCategory(product.getCategory());
        response.setQuantity(product.getQuantity());
        response.setProductGallery(product.getProductGallery());
        return response;
    }
}
