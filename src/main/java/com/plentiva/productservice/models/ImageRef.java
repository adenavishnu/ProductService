package com.plentiva.productservice.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ImageRef implements Serializable {
    private String imageId;
    private String url;
}