package com.ecommerce.productsservice.dtos;

import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.ImageRef;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductResponse {
    private UUID id;
    private String productName;
    private String description;
    private Category category;
    private Double price;
    private ImageRef thumbnail;
    private List<ImageRef> productGallery;
    private List<ImageRef> gallery;
    private Integer quantity;
}
