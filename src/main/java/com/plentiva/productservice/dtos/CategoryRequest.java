package com.plentiva.productservice.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Slug is required")
    private String slug;

    private String imageUrl;

    private Boolean isActive = true;

    private Integer displayOrder;

    // For hierarchy
    private UUID parentId;
}
