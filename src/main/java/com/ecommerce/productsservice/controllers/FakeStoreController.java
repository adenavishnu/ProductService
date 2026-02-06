package com.ecommerce.productsservice.controllers;

import com.ecommerce.productsservice.models.Category;
import com.ecommerce.productsservice.models.Product;
import com.ecommerce.productsservice.services.FakeStoreService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fakestore/products")
public class FakeStoreController {

    private final FakeStoreService fakeStoreService;

    public FakeStoreController(FakeStoreService fakeStoreService) {
        this.fakeStoreService = fakeStoreService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return fakeStoreService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        return products;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        product.setId(1L);
        return product;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return product;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    }

    @GetMapping("/category")
    public Category getCategory() {
        return new Category();
    }
}
