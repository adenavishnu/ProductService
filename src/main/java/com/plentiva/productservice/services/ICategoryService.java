package com.plentiva.productservice.services;

import com.plentiva.productservice.dtos.CategoryRequest;
import com.plentiva.productservice.dtos.CategoryResponse;

import java.util.List;

public interface ICategoryService {

    CategoryResponse save(CategoryRequest request) throws Exception;

    CategoryResponse update(String id, CategoryRequest request) throws Exception;

    void delete(String id) throws Exception;

    CategoryResponse findById(String id) throws Exception;

    List<CategoryResponse> findAll() throws Exception;
}
