//package com.ecommerce.productsservice.controllers;
//
//import com.ecommerce.productsservice.models.Category;
//import com.ecommerce.productsservice.models.Product;
//import com.ecommerce.productsservice.services.FakeStoreServiceI;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/fakestore/products")
//public class FakeStoreController {
//
//    private final FakeStoreServiceI fakeStoreService;
//
//    public FakeStoreController(FakeStoreServiceI fakeStoreService) {
//        this.fakeStoreService = fakeStoreService;
//    }
//
//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
//        return fakeStoreService.getProductById(id);
//    }
//
//    @GetMapping()
//    public List<Product> getProducts() {
//        return fakeStoreService.getAllProducts();
//    }
//
//    @PostMapping()
//    public Product createProduct(@RequestBody Product product) {
//        return fakeStoreService.saveProduct(product);
//    }
//
//    @PatchMapping("/{id}")
//    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
//        return fakeStoreService.updateProduct(id, product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//    }
//
//    @GetMapping("/category")
//    public Category getCategory() {
//        return new Category();
//    }
//}
