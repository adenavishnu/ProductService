package com.plentiva.productservice.controllers;

import com.plentiva.productservice.dtos.ProductRequest;
import com.plentiva.productservice.dtos.ProductResponse;
import com.plentiva.productservice.models.Category;
import com.plentiva.productservice.models.Product;
import com.plentiva.productservice.services.IProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Getting Products
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping()
    public Product createProduct(@RequestBody ProductRequest product) {
        return productService.saveProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        product.setId(
                id);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable Long id) {
        Product product = new Product();
        return new ArrayList<>();
    }

    @GetMapping("/categories")
    public List<Product> getCategories() {
        Category category = new Category();
        return new ArrayList<>();
    }

}
