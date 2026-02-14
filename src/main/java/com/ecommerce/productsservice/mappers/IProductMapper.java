package com.ecommerce.productsservice.mappers;

import com.ecommerce.productsservice.dtos.ProductRequest;
import com.ecommerce.productsservice.dtos.ProductResponse;
import com.ecommerce.productsservice.models.Product;

public interface IProductMapper {

    Product toModel(ProductRequest request);

    ProductResponse toResponse(Product product);
}
