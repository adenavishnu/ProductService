//package com.ecommerce.productsservice.services;
//
//import com.ecommerce.productsservice.dtos.FakeStoreDto;
//import com.ecommerce.productsservice.mappers.IProductMapper;
//import com.ecommerce.productsservice.models.Product;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class FakeStoreServiceI implements IProductService {
//
//    private final RestTemplate restTemplate;
//    private final IProductMapper productMapper;
//
//    public FakeStoreServiceI(RestTemplate restTemplate, IProductMapper productMapper) {
//        this.restTemplate = restTemplate;
//        this.productMapper = productMapper;
//    }
//
//    private Product getProduct(FakeStoreDto entity) {
//        return productMapper.toModels(entity);
//    }
//
//    private FakeStoreDto getFakeStoreDto(Product product) {
//        return productMapper.toFakeStoreDto(product);
//    }
//
//    @Override
//    public Product getProductById(Long id) throws ChangeSetPersister.NotFoundException {
//        FakeStoreDto product = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreDto.class);
//        if (product == null) {
//            throw new ChangeSetPersister.NotFoundException();
//        }
//
//        return getProduct(product);
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        FakeStoreDto[] response =
//                restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreDto[].class);
//        if (response == null || response.length == 0) {
//            return Collections.emptyList();
//        }
//        return Arrays.stream(response)
//                .map(this::getProduct)
//                .toList();
//    }
//
//    /**
//     * @param product
//     * @return
//     */
//    @Override
//    public Product saveProduct(Product product) {
//        FakeStoreDto fakeStoreDto = getFakeStoreDto(product);
//        FakeStoreDto response = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreDto, FakeStoreDto.class);
//        return getProduct(response);
//    }
//
//    /**
//     * @param product
//     * @return
//     */
//    @Override
//    public Product updateProduct(Long id, Product product) {
//        FakeStoreDto fakeStoreDto = getFakeStoreDto(product);
//        FakeStoreDto response = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, fakeStoreDto, FakeStoreDto.class);
//        return getProduct(response);
//    }
//
//    /**
//     * @param id
//     */
//    @Override
//    public void deleteProduct(Long id) {
//        restTemplate.delete("https://fakestoreapi.com/products/" + id);
//    }
//
//}
