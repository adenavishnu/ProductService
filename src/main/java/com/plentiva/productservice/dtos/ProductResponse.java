package com.plentiva.productservice.dtos;

import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.models.ImageRef;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductResponse implements Serializable {
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
