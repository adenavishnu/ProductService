package com.plentiva.productservice.dtos;

// import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.models.ImageRef;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest implements Serializable {

    @NotBlank
    @Size(min = 3, max = 100)
    private String productName;

    private String description;
    private UUID categoryId;


    @DecimalMin("0.0")
    private Double price;

    @NotNull
    private ImageRef thumbnail;

    private List<ImageRef> productGallery;

    @NotNull
    @Min(0)
    private Integer quantity;
}
