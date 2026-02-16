package com.plentiva.productservice.controllers;

import com.plentiva.productservice.dtos.CategoryRequest;
import com.plentiva.productservice.dtos.CategoryResponse;
import com.plentiva.productservice.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/categories")
public class CategoriesController {

    private final ICategoryService categoryService;

    public CategoriesController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // CREATE CATEGORY
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) throws Exception {
        return ResponseEntity.ok(categoryService.save(request));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() throws Exception {
        return ResponseEntity.ok(categoryService.findAll());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable String id,
                                                   @RequestBody CategoryRequest request) throws Exception {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws Exception {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
