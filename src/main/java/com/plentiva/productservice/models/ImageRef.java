package com.plentiva.productservice.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ImageRef {
    private String imageId;
    private String fileName;
    private String url;
}