package com.ecommerce.productsservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    @Column(nullable = false, length = 100)
    private String productName;
    private String description;
    private double price;
    @Embedded
    private ImageRef thumbnail;
    @ElementCollection
    private List<ImageRef> productGallery;
    private Integer quantity;
    @ManyToOne
    private Category category;
}
