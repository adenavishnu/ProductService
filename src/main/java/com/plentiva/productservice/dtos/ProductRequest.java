package com.plentiva.productservice.dtos;

import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.models.ImageRef;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    private UUID id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String productName;

    private String description;
    private Category category;


    @DecimalMin("0.0")
    private Double price;

    @NotNull
    private ImageRef thumbnail;

    private List<ImageRef> productGallery;

    @Size(min = 1)
    private List<ImageRef> gallery;

    @NotNull
    @Min(0)
    private Integer quantity;
}
