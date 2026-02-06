package com.ecommerce.productsservice.controllers;

import com.ecommerce.productsservice.models.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        Product product = new Product();
        product.setId(id);
        return  product;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        product.setId(1L);
        return product;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return product;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
    }

}
