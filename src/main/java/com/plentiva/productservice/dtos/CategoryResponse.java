package com.plentiva.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponse {

    private UUID id;

    private String name;

    private String description;

    private String slug;

    private String imageUrl;

    private Boolean isActive;

    private Integer displayOrder;

    private UUID parentId;

    private Instant dateCreated;
}
