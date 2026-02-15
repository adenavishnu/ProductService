package com.plentiva.productservice.mappers;

import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.models.Product;

public interface IProductMapper {

    Product toModel(ProductRequest request);

    ProductResponse toResponse(Product product);
}
